package step2.domain.lotto;

import step2.util.LottoNumberGenerator;

public class BuyLotto {
    private static final int DEFAULT_LOTTO_PRICE = 1000;

    private int lottoQuantity;

    public BuyLotto(int inputMoney) {
        validate(inputMoney);
        this.lottoQuantity = inputMoney;
    }

    private void validate(int inputMoney) {
        if (inputMoney < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다");
        }
    }

    public int getLottoQuantity() {
        return lottoQuantity / DEFAULT_LOTTO_PRICE;
    }

    public Lottos lottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        return Lottos.makeLottos(getLottoQuantity(), lottoNumberGenerator);
    }
}
