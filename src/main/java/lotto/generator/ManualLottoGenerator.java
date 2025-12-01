package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<String> manualValues;

    public ManualLottoGenerator(List<String> manualValues) {
        this.manualValues = manualValues;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (String value : manualValues) {
            lottos.add(new Lotto(value));
        }
        return new Lottos(lottos);
    }
}
