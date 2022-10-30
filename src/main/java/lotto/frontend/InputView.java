package lotto.frontend;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String ENTER_MONEY = "구매 금액을 입력해주세요.";
    private static final String ENTER_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public int askEnterMoney() {
        System.out.println(ENTER_MONEY);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public List<Integer> askEnterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBER);
        return Arrays.stream(SCANNER.nextLine().split(COMMA_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int askEnterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        int bonus = Integer.parseInt(SCANNER.nextLine());
        return bonus;
    }
}
