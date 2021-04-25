package com.puzzle;

import com.puzzle.utils.MessagesConstant;
import com.puzzle.validator.CSVFileValidator;

/**
 * Main class to validate Sudoku.
 */
public class Sudoku {

    public static void main(String[] args) {
        try {
            boolean isValid = new CSVFileValidator().validate(args);
            if (!isValid) {
                errorMessageHandler(MessagesConstant.INVALID_FORMAT);
            } else {
                successMessageHandler();
            }
        } catch (Exception e) {
            errorMessageHandler(e.getMessage());
        }
    }

    private static void successMessageHandler() {
        System.out.println(MessagesConstant.VALID_CODE);
        System.out.println(MessagesConstant.VALID_FORMAT);
    }

    private static void errorMessageHandler(final String message) {
        System.out.println(MessagesConstant.INVALID_CODE);
        System.out.println(message);
        System.exit(-1);
    }
}
