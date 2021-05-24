package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Price buyPrice;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoMachine(Price buyPrice) {
        this.buyPrice = buyPrice;
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    public Lottos createLottos() {
        List<LottoNumbers> lottos = new ArrayList<>();
        long buyCount = buyPrice.getPrice() / Lotto.LOTTO_PRICE;
        for (int i = 0; i < buyCount; i++) {
            lottos.add(this.lottoNumbersGenerator.generateRandomLottoNumbers());
        }
        return new Lottos(lottos);
    }
}
