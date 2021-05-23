package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Price price;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoMachine(int price) {
        this.price = new Price(price);
        this.lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    public Lottos getLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price.getCountAvailableForBuy(); i++) {
            lottos.add(new Lotto(this.lottoNumbersGenerator.generateRandomLottoNumbers()));
        }
        return new Lottos(lottos);
    }
}
