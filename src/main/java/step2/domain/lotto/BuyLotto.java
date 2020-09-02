package step2.domain.lotto;

import java.util.List;

public class BuyLotto {
    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "로또를 구매할 돈이 부족합니다";

    private int lottoQuantity;
    private int manualLottoCount;

    public BuyLotto(int inputMoney, int manualLottoCount) {
        validate(inputMoney);
        this.lottoQuantity = inputMoney;
        this.manualLottoCount = manualLottoCount;
    }

    private void validate(int inputMoney) {
        if (inputMoney < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE);
        }
    }

    public int getLottoQuantity() {
        return lottoQuantity / DEFAULT_LOTTO_PRICE - manualLottoCount;
    }

    public int getManualLottoQuantity() {
        return manualLottoCount;
    }

    public Lottos lottoTicket(List<String> manualLottos) {
        return Lottos.of(getLottoQuantity(), manualLottoCount, manualLottos);
    }
}
