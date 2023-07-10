package lotto.input;

import java.util.List;
import java.util.Scanner;

public class LottoInput {

    private final Scanner scanner;

    public LottoInput() {
        this.scanner = new Scanner(System.in);
    }

    public int inputAmount() {
        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
