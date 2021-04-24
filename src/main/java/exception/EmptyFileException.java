package exception;

import utils.MessagesConstant;

public class EmptyFileException extends Exception{
    public EmptyFileException() {
        super(MessagesConstant.EMPTY_FILE);
    }
}
