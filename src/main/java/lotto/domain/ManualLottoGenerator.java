package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private ManualLottoMemo manualLottoMemo;
    private final List<Lotto> lottos = new ArrayList<>();

    public ManualLottoGenerator(ManualLottoMemo manualLottoMemo) {
            this.manualLottoMemo = getManualLottoMemoAfterValidateNullEmpty(manualLottoMemo);
    }

    @Override
    public List<Lotto> generator() {
        for (List<LottoNumber> lottoNumbers : manualLottoMemo.getLottoMemos()) {
            lottos.add(Lotto.of(lottoNumbers));
        }
        return lottos;
    }

    public ManualLottoMemo getManualLottoMemoAfterValidateNullEmpty(ManualLottoMemo memo) {
        if(memo == null) {
            return ManualLottoMemo.empty();
        }
        return memo;
    }
}
