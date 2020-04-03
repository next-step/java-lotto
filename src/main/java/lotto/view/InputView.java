package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MSG_MONEY_INPUT = "구입금액을 숫자로 입력해 주세요.";
    private static final String MSG_LOTTO_COUNT = "수동으로 구매할 로또 갯수를 숫자로 입력해 주세요.";
    private static final String WARNING_MONEY_INPUT = "구입금액은 1000원 이상만 입력 가능합니다.";
    private static final String WARNING_LOTTO_COUNT = "로또 금액이 부족합니다. 갯수를 다시 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MINIMUM_MONEY_TO_BUY = 1000;

    private static int lottoCount;
    private static int lottoCountManual;
    private static int lottoCountAuto = lottoCount - lottoCountManual;

    public static int getInputForMoney() {
        System.out.println(MSG_MONEY_INPUT);
        int money = scanner.nextInt();
        validateGreaterThan1000(isGreaterThan1000(money));
        lottoCount = money / MINIMUM_MONEY_TO_BUY;
        return lottoCount;
    }

    public static int getInputForLottoCountManual() {
        System.out.println(MSG_LOTTO_COUNT);
        int lottoCount = scanner.nextInt();
        validatePurchasable(isPurchasable(lottoCount));
        lottoCountManual = lottoCount;
        return lottoCountManual;
    }

    private static boolean isPurchasable(int lottoCountManul) {
        return lottoCountManul <= lottoCount;
    }

    private static void validatePurchasable(boolean isPurchasable) {
        if (!isPurchasable) {
            System.out.println(WARNING_LOTTO_COUNT);
            getInputForLottoCountManual();
        }
    }

    private static boolean isGreaterThan1000(int money) {
        return money >= MINIMUM_MONEY_TO_BUY;
    }

    private static void validateGreaterThan1000(boolean isGreaterThan1000) {
        if (!isGreaterThan1000) {
            System.out.println(WARNING_MONEY_INPUT);
            getInputForMoney();
        }
    }
}
