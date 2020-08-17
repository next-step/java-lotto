package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.domain.WinningNumbers;
import kr.heesu.lotto.enums.Message;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ", ";
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public PurchaseAmount getPurchaseAmount() {
        System.out.println(Message.INPUT_FOR_PURCHASE_AMOUNT.of());

        String amount = scanner.nextLine();
        return PurchaseAmount.of(Integer.parseInt(amount));
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println(Message.INPUT_FOR_WINNING_NUMBERS.of());

        String input = scanner.nextLine();

        List<Integer> numbers = Stream.of(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return WinningNumbers.of(numbers);
    }

    public static InputView of() {
        return new InputView();
    }
}
