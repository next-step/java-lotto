package lotto.input;

import java.util.Scanner;

public class LottoInput {

    private final Scanner scanner;

    public LottoInput() {
        this.scanner = new Scanner(System.in);
    }

    public int inputAmount() {
        return scanner.nextInt();
    }
}
