package lotto.view;

import lotto.common.MessageCode;

import java.util.Scanner;

public class InputView {
    Scanner scan;

    public InputView() {
        scan = new Scanner(System.in);
    }

    public int inputMoneyForLotto() {
        System.out.println(MessageCode.INPUT_MONEY_FOR_LOTTO.message());
        return scan.nextInt();
    }

    public String inputLastWonLottoNumbers() {
        System.out.println(MessageCode.INPUT_LAST_WON_LOTTO_NUMBERS.message());
        return scan.next();
    }

    public String inputBonusLottoNumber() {
        System.out.println(MessageCode.INPUT_LAST_WON_BONUS_NUMBER.message());
        return scan.next();
    }

    public int inputCountForManualLotto() {
        System.out.println(MessageCode.INPUT_COUNT_MANUAL_LOTTO.message());
        return scan.nextInt();
    }
}
