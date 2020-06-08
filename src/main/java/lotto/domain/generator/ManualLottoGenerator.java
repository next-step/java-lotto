package lotto.domain.generator;

import lotto.domain.data.ManualLottoMemo;
import lotto.domain.data.Lotto;
import lotto.domain.data.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManualLottoGenerator {

    public static List<Lotto> generate(ManualLottoMemo manualLottoMemo) {
        final List<Lotto> lottos = new ArrayList<>();
        ManualLottoMemo manualMemo = Optional.ofNullable(manualLottoMemo).orElse(ManualLottoMemo.empty());
        for (List<LottoNumber> lottoNumbers : manualMemo.getLottoMemos()) {
            lottos.add(Lotto.of(lottoNumbers));
        }
        return lottos;
    }

}
