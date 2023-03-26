package lotto.view;

import lotto.utility.InputUtil;


public class InputView {

    private static final long MIN_AMOUNT = 1000;

    private final InputUtil inputUtil = new InputUtil();

    public long purchaseAmount() {
        long amount = inputUtil.inputToLong("구입금액을 입력해 주세요.");

        if (amount < MIN_AMOUNT ) {
            throw new IllegalArgumentException("구매 금액은 1000원 이상");
        }
        return amount;
    }

    public int manualPurchaseCount() {

        return inputUtil.inputToInt("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public String[] inputManualLotto(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] manualLottos = new String[count];

        for (int i = 0; i < count; i++) {
            manualLottos[i] = inputUtil.inputToLine();
        }

        return manualLottos;
    }


    public String inputWinningNumber() {
        return inputUtil.inputToLine("지난 주 당첨 번호를 입력해주세요.");
    }

    public int inputBonusNumber() {

        return inputUtil.inputToInt("보너스 볼을 입력해 주세요.");
    }
}
