package validator;

import exception.EmptyFileException;
import utils.MessagesConstant;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileValidator {

    boolean isValid = false;

    public boolean validate(String filenameCSV) throws EmptyFileException,IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filenameCSV);

        if (inputStream == null) {
            File file = new File(filenameCSV);

            if (!file.exists()) {
                throw new FileNotFoundException( "Error: Cannot find the file with filename : " + filenameCSV);
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
