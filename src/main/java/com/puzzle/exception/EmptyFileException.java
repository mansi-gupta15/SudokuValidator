package com.puzzle.exception;

import com.puzzle.utils.MessagesConstant;

/**
 * Custom exception for empty file.
 */
public class EmptyFileException extends Exception {
    /**
     * Constructor to print message.
     */
    public EmptyFileException() {
        super(MessagesConstant.EMPTY_FILE);
    }
}
