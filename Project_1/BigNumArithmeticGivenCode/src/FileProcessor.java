import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {
    private LinkedListCustom number1;
    private LinkedListCustom number2;

    public FileProcessor() {
        number1 = new LinkedListCustom();
        number2 = new LinkedListCustom();
    }

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public void processFile(String filePath) {
        File infile = new File(filePath);

        try {
            Scanner scan = new Scanner(infile);
            number1 = new LinkedListCustom(); // Clear the existing linked lists
            number2 = new LinkedListCustom();

            while (scan.hasNext()) {
                String line = scan.nextLine();
                line = line.replaceAll("\\s", "").replaceAll("\\b0+(?!\\b)", "");

                StringBuilder num1 = new StringBuilder();
                StringBuilder operator = new StringBuilder();
                boolean isOperator = false;

                if (!line.isEmpty()) {
                    for (char c : line.toCharArray()) {
                        if (Character.isDigit(c)) {
                            if (isOperator) {
                                operator.append(c);
                            } else {
                                num1.append(c);
                            }
                        } else {
                            isOperator = true;
                            operator.append(c);
                        }
                    }
                }
                String numb1 = num1.substring(0);
                String num2 = operator.substring(1);
                String operation = operator.substring(0, 1);

                // Convert the digits of num1 and num2 into linked lists

                String flippednumb1 = new StringBuilder(numb1).reverse().toString();
                String flippednum2 = new StringBuilder(num2).reverse().toString();

                for (char c : flippednumb1.toCharArray()) {
                    int digit = Character.getNumericValue(c);
                    number1.insertDigit(digit);
                }

                for (char c : flippednum2.toCharArray()) {
                    int digit = Character.getNumericValue(c);
                    number2.insertDigit(digit);
                }
            }

            scan.close(); // Close the scanner when done
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public LinkedListCustom getNumber1() {
        return number1;
    }

    public LinkedListCustom getNumber2() {
        return number2;
    }
}