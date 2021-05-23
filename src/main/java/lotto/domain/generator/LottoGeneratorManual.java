package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorManual implements LottoGenerator {

    private List<String> manualLottoStrings;

    public LottoGeneratorManual(List<String> manualLottoStrings) {
        this.manualLottoStrings = manualLottoStrings;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (String manualLottoString : manualLottoStrings) {
            lottos.add(new Lotto(manualLottoString));
        }
        return new Lottos(lottos);
    }
}
