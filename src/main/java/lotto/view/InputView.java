package lotto.view;

import lotto.domain.numbers.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_TEXT = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public static long enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    public static List<LottoNumber> enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        return Arrays.stream(winningNumbers.split(SPLIT_TEXT))
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    public static int enterBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }
}
