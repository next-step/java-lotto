package lotto.domain.generator;

import lotto.domain.data.ManualLottoMemo;
import lotto.domain.data.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generate(int autoCount, ManualLottoMemo manualLottoMemo) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(ManualLottoGenerator.generate(manualLottoMemo));
        lottos.addAll(AutoLottoGenerator.generate(autoCount));
        return lottos;
    }
}
