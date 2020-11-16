package lotto.view;

import java.util.Scanner;

public class InputChannel implements Input {
    Scanner scanner;

    public InputChannel() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String input(String s) {
        System.out.println(s);
        return scanner.next();
    }
}
