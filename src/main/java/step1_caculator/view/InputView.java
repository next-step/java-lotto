package step1_caculator.view;

import step1_caculator.util.TextParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static List<String> scanInputs() {
        String text = scanner.nextLine();
        List<String> inputs = TextParser.textToStringList(text);
        return inputs;
    }
}
