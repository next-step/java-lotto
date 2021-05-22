package lotto.view;

import lotto.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMbERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return StringUtils.parseInteger(SCANNER.nextLine());
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMbERS_MESSAGE);
        return SCANNER.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
