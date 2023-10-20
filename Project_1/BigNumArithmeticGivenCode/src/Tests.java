import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void testToString() {
        LinkedListCustom test = new LinkedListCustom();
        test.insertDigit(0);
        test.insertDigit(0);
        test.insertDigit(1);
        assertEquals("0 -> 0 -> 1", test.numberAsLinkedListString());
        LinkedListCustom test2 = new LinkedListCustom();
        test2.insertDigit(1);
        test2.insertDigit(2);
        assertEquals("1 -> 2", test2.numberAsLinkedListString());
    }

    @Test
    public void testStringtoList() {
        LinkedListCustom test = new LinkedListCustom();
        test.insertDigit(0);
        test.insertDigit(0);
        test.insertDigit(1);
        String input = "12345"; // Example input string
        LinkedListCustom linkedList = new LinkedListCustom();
        String flippedInput = new StringBuilder(input).reverse().toString();

        for (char c : flippedInput.toCharArray()) {
            int digit = Character.getNumericValue(c);
            linkedList.insertDigit(digit);
        }
        String tests = test.numberAsLinkedListString();
        String linkedlists = linkedList.numberAsLinkedListString();
        System.out.println(linkedlists);
        System.out.println(tests);

    }

    @Test
    public void testProcessFile() {
        // Prepare a test file with content "100 + 782"
        String testFilePath = "test_input.txt";
        try {
            FileWriter fileWriter = new FileWriter(testFilePath);
            fileWriter.write("100 + 782");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileProcessor f = new FileProcessor();
        f.processFile("test_input.txt");
        LinkedListCustom l1 = f.getNumber1();
        String linkedliststring1 = l1.numberAsLinkedListString();
        assertEquals("0 -> 0 -> 1", linkedliststring1);
    }


}
