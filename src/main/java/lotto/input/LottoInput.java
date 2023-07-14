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

    private Long inputAmount() {
        return Long.parseLong(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        return Arrays.stream(scanner.nextLine().split(WINNING_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Long inputPurchaseMoney() {
        return inputAmount();
    }

    public int inputBonusNumber() {
        return inputAmount().intValue();
    }
}
