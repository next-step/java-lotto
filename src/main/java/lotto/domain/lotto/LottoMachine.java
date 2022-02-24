package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private final List<Lotto> lottos;

    public LottoMachine(int money, LottoCreator lottoCreator) {
        this.lottos = createLottos(lottoCreator, calculateQuantity(money));
    }

    private int calculateQuantity(int money) {
        if (money < LOTTO_PRICE.intValue()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return new BigDecimal(money).divide(LOTTO_PRICE, RoundingMode.FLOOR).intValue();
    }

    private List<Lotto> createLottos(LottoCreator lottoCreator, int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(lottoCreator.createLotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
