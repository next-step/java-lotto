package lotto.model;

import common.model.Number;
import lotto.factory.LottoNumbersFactory;
import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    private final List<LottoNumbers> lotto;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public Lotto(int count) {
        this.lotto = createAutoLottoNumbers(count);
    }

    public Lotto(List<LottoNumbers> manualLottoNumbers, int autoLottoCount) {
        manualLottoNumbers.addAll(createAutoLottoNumbers(autoLottoCount));
        this.lotto = manualLottoNumbers;
    }

    private List<LottoNumbers> createAutoLottoNumbers(int count) {
        List<LottoNumbers> autoLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoLotto.add(LottoNumbersFactory.createByGenerator(new LottoNumberGenerator()));
        }
        return autoLotto;
    }

    public LottoReport matchAll(LottoWinner winner) {
        LottoReport report = new LottoReport();

        for (LottoNumbers lottoNumbers : this.lotto) {
            report.increaseCount(winner.match(lottoNumbers));
        }

        return report;
    }

    public int getLottoSize() {
        return lotto.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoNumbers lottoNumbers : lotto) {
            builder.append(lottoNumbers.toString()).append("\n");
        }
        return builder.toString();
    }
}
