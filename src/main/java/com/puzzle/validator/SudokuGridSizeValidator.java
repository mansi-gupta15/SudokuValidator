package com.puzzle.validator;

import com.puzzle.utils.MessagesConstant;
import java.util.HashSet;

public class SudokuGridSizeValidator {

    private static final int MAX_SIZE = 9;
    HashSet<String> traverse = new HashSet<>();

    public boolean sudokuGridSizeValidator(Integer[][] cells) {

        if (cells.length == 0) {
            throw new IllegalArgumentException(MessagesConstant.EMPTY_FILE);
        }

        if (cells.length != MAX_SIZE) {
            throw new IllegalArgumentException(MessagesConstant.ROWS_VALIDATION);
        }

        if (cells[0].length != MAX_SIZE) {
            throw new IllegalArgumentException(MessagesConstant.COLUMN_VALIDATION);
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!traverse.add(cells[i][j]+ MessagesConstant.FOUND_IN_ROW + i) ||
                  !traverse.add(cells[i][j]+ MessagesConstant.FOUND_IN_COLUMN + j) ||
                  !traverse.add(cells[i][j]+ MessagesConstant.FOUND_IN_SUB_BOX + i/3 + "-" + j/3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
