package com.puzzle.exception;

import com.puzzle.utils.MessagesConstant;

public class MissingFileNameException extends Exception{

    public MissingFileNameException() {
        super(MessagesConstant.NO_FILE);
    }
}
