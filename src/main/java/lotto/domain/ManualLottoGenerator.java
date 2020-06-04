package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator{

    private final ManualLottoMemo manualLottoMemo;

    public ManualLottoGenerator(ManualLottoMemo manualLottoMemo) {
        this.manualLottoMemo = manualLottoMemo;
    }

    @Override
    public List<Lotto> generator() {
        List<Lotto> lottos = new ArrayList<>();
        for (List<LottoNumber> lottoNumbers : manualLottoMemo.getLottoMemos()) {
            lottos.add(Lotto.of(lottoNumbers));
        }
        return lottos;
    }
}
