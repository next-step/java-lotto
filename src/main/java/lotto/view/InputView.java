package lotto.view;

import java.util.Scanner;

public class InputView {

    public String input() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
