package lotto.view;

import lotto.util.InputUtils;

public class InputView {
    private static final int EACH_PRICE = 1000;

    public static int inputPurchaseAmount() {
        String purchaseAmount = InputUtils.scan("구매금액을 입력해 주세요.");
        return Integer.parseInt(purchaseAmount);
    }

    public static int inputPurchaseManualLotteryAmount() {
        String purchaseManualLotteryAmount = InputUtils.scan("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(purchaseManualLotteryAmount);
    }

    public static void inputManualLotteryAmount() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
    }

    public static String inputManualLottery() {
        return InputUtils.scan();
    }

    public static void printPurchaseAmount(int purchasePrice, int manualLotteryAmount) {
        System.out.println("수동으로 " + manualLotteryAmount + "장, 자동으로 " + (purchasePrice / EACH_PRICE - manualLotteryAmount) + "개를 구매했습니다.");
    }


    public static String inputWinningNumbers() {
        return InputUtils.scan("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static String inputBonusNumber() {
        return InputUtils.scan("보너스 볼을 입력해 주세요.");
    }
}
