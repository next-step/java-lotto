package lotto.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String ENTER_MONEY = "구매 금액을 입력해주세요.";
    private static final String ENTER_COUNT_OF_CUSTOM_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_CUSTOM_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public int askEnterMoney() {
        System.out.println(ENTER_MONEY);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public int askEnterCountOfCustomLotto() {
        System.out.println(ENTER_COUNT_OF_CUSTOM_LOTTO);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public List<List<Integer>> askEnterCustomNumbers(int count) {
        System.out.println(ENTER_CUSTOM_NUMBERS);
        List<List<Integer>> customNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            customNumbers.add(inputNumber());
        }
        return customNumbers;
    }

    public List<Integer> askEnterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBER);
        return inputNumber();
    }

    private List<Integer> inputNumber() {
        return Stream.of(SCANNER.nextLine().split(COMMA_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public int askEnterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
