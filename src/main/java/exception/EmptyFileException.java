package exception;

public class EmptyFileException extends Exception{
    public EmptyFileException() {
        super("Error: The file is empty");
    }
}
