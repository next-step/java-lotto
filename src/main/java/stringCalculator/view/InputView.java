package stringCalculator.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputStringLine(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
