import javax.swing.*;
import java.io.FileNotFoundException;

public class BigNumArithmetic {

    public BigNumArithmetic(int i) {
    }

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Expected exactly 1 argument: a file name.");
            
        }
       /* String filePath = args[0];
        FileProcessor.processFile(filePath); */
    }
}

