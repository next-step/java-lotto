package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    public static final String WINNING_DELIMITER = ", ";
    private final Scanner scanner;

    public LottoInput() {
        this.scanner = new Scanner(System.in);
    }

    public int inputAmount() {
        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumbers() {
        return Arrays.stream(scanner.nextLine().split(WINNING_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
