package calculator;

import java.util.Scanner;

public class StringCalculatorView {
    public String getStringInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printToConsole(Object content) {
        System.out.println(content);
    }
}
