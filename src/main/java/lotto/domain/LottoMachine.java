package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.intf.NumbersGenerator;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private NumbersGenerator generator;

    public LottoMachine(NumbersGenerator generator) {
        this.generator = generator;
    }

    public Lottos createLottos(Price price, List<LottoNumbers> manualLottoNumbers) {
        Long autoLottoCount = (price.getPrice() / LOTTO_PRICE) - manualLottoNumbers.size();
        List<LottoNumbers> lottos = new ArrayList<>();
        lottos.addAll(manualLottoNumbers);
        lottos.addAll(createAutoLottos(autoLottoCount));
        return new Lottos(lottos);
    }

    private List<LottoNumbers> createAutoLottos(Long autoLottoCount) {
        List<LottoNumbers> autoLottos = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottos.add(this.generator.generateLottoNumbers());
        }
        return autoLottos;
    }
}
