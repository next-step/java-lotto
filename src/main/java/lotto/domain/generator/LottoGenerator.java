package lotto.domain.generator;

import lotto.domain.data.ManualLotto;
import lotto.domain.data.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generate(int autoCount, List<ManualLotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(ManualLottoGenerator.generate(manualLottos));
        lottos.addAll(AutoLottoGenerator.generate(autoCount));
        return lottos;
    }
}
