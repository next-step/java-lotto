package lotto.view;

import java.util.Scanner;

public class InputView {

    public String LineInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    public long LongInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLong();
        }
    }
}
