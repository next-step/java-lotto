package lotto.view;

import lotto.domain.numbers.LottoNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static long enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    public static String enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static LottoNumber enterBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            return new LottoNumber(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }
}
