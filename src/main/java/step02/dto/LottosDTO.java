package step02.dto;

import step02.model.lotto.LottoCount;
import step02.model.lotto.LottoNumbers;

import java.util.List;

public class LottosDTO {
    private final List<LottoNumbers> lottos;
    private final LottoCount lottoCount;

    public LottosDTO(List<LottoNumbers> lottos, LottoCount lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public List<LottoNumbers> getLottos() {
        return lottos;
    }

    public int getManualLottoCount() {
        return this.lottoCount.getManualCount();
    }

    public int getAutomaticLottoCount() {
        return this.lottoCount.getAutomaticCount();
    }
}
