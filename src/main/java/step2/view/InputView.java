package step2.view;

import step2.model.LottoNumber;
import step2.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String WINNING_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static Money getPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        int useAmount = Integer.parseInt(scanner.nextLine());

        return Money.valueOf(useAmount);
    }

    public static List<LottoNumber> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumberTokens = scanner.nextLine().split(WINNING_NUMBER_DELIMITER);

        try {
            return Arrays.stream(winningNumberTokens)
                    .map(Integer::parseInt)
                    .map(LottoNumber::valueOf)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력 가능합니다.");
        }
    }
}
