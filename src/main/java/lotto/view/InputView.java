package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getNumber() {
        return scanner.nextLine();
    }
}
