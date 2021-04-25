package com.puzzle.exception;

import com.puzzle.utils.MessagesConstant;

/**
 * Custom exception for missing file name.
 */
public class MissingFileNameException extends Exception {

    /**
     * Constructor to print message.
     */
    public MissingFileNameException() {
        super(MessagesConstant.NO_FILE);
    }
}
