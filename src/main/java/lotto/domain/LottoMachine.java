package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Price price;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoMachine(Price price) {
        this.price = price;
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    public Lottos getLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price.getAvailableCountForBuy(); i++) {
            lottos.add(new Lotto(this.lottoNumbersGenerator.generateRandomLottoNumbers()));
        }
        return new Lottos(lottos);
    }
}
