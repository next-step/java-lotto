package step2.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int nextAmount() {
        return scanner.nextInt();
    }

    public String nextLottoNum() {
        return scanner.next();
    }

}
