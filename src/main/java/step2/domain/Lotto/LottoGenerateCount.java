package step2.domain.Lotto;

import step2.domain.InputMoney;

public final class LottoGenerateCount {

    private final static int DIVIDE_STANDARD = 1000;

    private int count;

    private LottoGenerateCount(int money) {
        this.count = (money/DIVIDE_STANDARD);
    }

    public static final LottoGenerateCount newInstance(InputMoney inputMoney) {
        return newInstance(inputMoney.getInputMoney());
    }

    public static final LottoGenerateCount newInstance(int money) {
        return new LottoGenerateCount(money);
    }


}
