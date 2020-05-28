package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String WINNING_NUMBER_DELIMITER = ",";
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Long askTotalMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.valueOf(SCANNER.nextLine());
    }

    public static Set<LottoNumber> askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
