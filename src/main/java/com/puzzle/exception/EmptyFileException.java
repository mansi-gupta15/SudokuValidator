package com.puzzle.exception;

import com.puzzle.utils.MessagesConstant;

public class EmptyFileException extends Exception{
    public EmptyFileException() {
        super(MessagesConstant.EMPTY_FILE);
    }
}
