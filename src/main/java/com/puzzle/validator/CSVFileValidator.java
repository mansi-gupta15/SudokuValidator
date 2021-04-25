package com.puzzle.validator;

import com.puzzle.exception.EmptyFileException;
import com.puzzle.exception.MissingFileNameException;
import com.puzzle.utils.MessagesConstant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Validator for validating file and file content.
 */
public class CSVFileValidator {

    private boolean isValid = false;

    /**
     * @param args
     * @return
     * @throws EmptyFileException
     * @throws IOException
     * @throws MissingFileNameException
     */
    public boolean validate(String[] args) throws EmptyFileException, IOException, MissingFileNameException {

        if (args.length != 1) {
            throw new MissingFileNameException();
        }
        String filenameCSV = args[0];
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filenameCSV);

        if (inputStream == null) {
            File file = new File(filenameCSV);

            if (!file.exists()) {
                throw new FileNotFoundException(MessagesConstant.INCORRECT_FILE_NAME + filenameCSV);
            }
            inputStream = new FileInputStream(file);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            List<List<Integer>> tableData = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(MessagesConstant.COMMA_DELIMITER);

                tableData.add(
                        Arrays.stream(values)
                                .map(String::trim)
                                .map(value -> value.isEmpty() ? null : Integer.valueOf(value))
                                .collect(Collectors.toList()));
            }

            if (tableData.isEmpty()) {
                throw new EmptyFileException();
            }

            isValid = new SudokuGridSizeValidator().sudokuGridSizeValidator(tableData.stream()
                    .map(columns -> columns.stream().toArray(Integer[]::new))
                    .toArray(Integer[][]::new));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessagesConstant.NUMERIC_VALIDATION + e.getMessage());
        }
        return isValid;
    }
}
