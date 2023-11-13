package src.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoGameNumberGenerator gameNumberGenerator;

    public LottoMachine(LottoGameNumberGenerator gameNumberGenerator) {
        this.gameNumberGenerator = gameNumberGenerator;
    }

    public Lottos buyLottos(Money money) {
        int lottoCount = money.lottoCount(Lotto.PRICE_OF_LOTTO);
        checkAvailableForPurchase(lottoCount);
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int idx = 0; idx < lottoCount; idx++) {
            lottos.add(buyLotto());
        }

        return Lottos.of(lottos);
    }

    private void checkAvailableForPurchase(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("로또의 가격은 " + Lotto.PRICE_OF_LOTTO + "원 입니다.");
        }
    }


    private Lotto buyLotto() {
        return Lotto.of(gameNumberGenerator.gameNumbers());
    }
}
