package view;

import utils.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputFormula() {
        return StringSplitter.splitDelimiter(scanner.nextLine());
    }
}
