import validator.CSVFileValidator;

public class Sudoku {

    public static void main(String[] args) {
        if (args.length != 1) {
            errorMessageHandler("Error: Please provide 1 filename..");
        }
        try{
            boolean isValid = new CSVFileValidator().validate(args[0]);
            if(!isValid){
                errorMessageHandler("Error: File is not a valid standard 9x9 Sudoku puzzle");
            } else {
                successMessageHandler();
            }
        } catch (Exception e) {
            errorMessageHandler(e.getMessage());
        }
    }

    private static void successMessageHandler() {
        System.out.println("0");
        System.out.println("Success: File is a valid standard 9x9 Sudoku puzzle");
    }

    private static void errorMessageHandler(final String message) {
        System.out.println("-1");
        System.out.println(message);
        System.exit(-1);
    }
}
