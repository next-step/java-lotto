package lotto.view;

import lotto.domain.LottoMoney;

import java.util.Scanner;

public class LottoInputView {

    private static final String NOTICE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INFORMATION_INPUT_COUNT = "개를 구매했습니다.";
    private static final String NOTICE_INPUT_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static LottoMoney inputMoney() {
        System.out.println(NOTICE_INPUT_MONEY);
        LottoMoney money = new LottoMoney(Integer.parseInt(SCANNER.nextLine()));
        System.out.println(money.lottoCount() + INFORMATION_INPUT_COUNT);
        return money;
    }

    public static String inputWinningNumbers() {
        System.out.println(NOTICE_INPUT_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(NOTICE_INPUT_BONUS_NUMBER);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
