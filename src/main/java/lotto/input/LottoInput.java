package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    private static final String WINNING_DELIMITER = ", ";
    private final Scanner scanner;

    public LottoInput() {
        this.scanner = new Scanner(System.in);
    }

    private long inputAmount() {
        return Long.parseLong(scanner.nextLine());
    }

    public List<Integer> inputLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(WINNING_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public long inputPurchaseMoney() {
        return inputAmount();
    }

    public int inputBonusNumber() {
        return Math.toIntExact(inputAmount());
    }

    public int inputManualQuantity() {
        return Math.toIntExact(inputAmount());
    }
}
