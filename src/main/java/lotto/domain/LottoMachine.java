package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.intf.NumbersGenerator;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final Price buyPrice;
    private NumbersGenerator numbersGenerator;

    public LottoMachine(Price buyPrice, NumbersGenerator numbersGenerator) {
        this.buyPrice = buyPrice;
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos createLottos() {
        List<LottoNumbers> lottos = new ArrayList<>();
        long buyCount = buyPrice.getPrice() / LOTTO_PRICE;
        for (int i = 0; i < buyCount; i++) {
            lottos.add(this.numbersGenerator.generateLottoNumbers());
        }
        return new Lottos(lottos);
    }
}
