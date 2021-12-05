package lotto.view;

import lotto.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBER_DELIMITER = ", ";

    public Money inputMoney() {
        System.out.println("구입 금액을 입력해주세요");
        return new Money(Integer.parseInt(SCANNER.nextLine()));
    }

    public List<Integer> inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return splitInputString(SCANNER.nextLine());
    }

    List<Integer> splitInputString(String input) {
        return Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
