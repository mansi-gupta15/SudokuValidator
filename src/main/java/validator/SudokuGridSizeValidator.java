package validator;

import java.util.HashSet;

public class SudokuGridSizeValidator {

    private static final int MAX_SIZE = 9;
    HashSet<String> traverse = new HashSet<>();

    public boolean sudokuGridSizeValidator(Integer[][] cells) {

        if (cells.length == 0) {
            throw new IllegalArgumentException("Error: The file is empty");
        }

        if (cells.length != MAX_SIZE) {
            throw new IllegalArgumentException("Error: The file must have a total of 9 rows");
        }

        if (cells[0].length != MAX_SIZE) {
            throw new IllegalArgumentException("Error: The file must have a total of 9 columns");
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!traverse.add(cells[i][j]+" found in row "+ i) ||
                  !traverse.add(cells[i][j]+" found in column "+ j) ||
                  !traverse.add(cells[i][j]+" found in sub box "+ i/3 + "-" + j/3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
