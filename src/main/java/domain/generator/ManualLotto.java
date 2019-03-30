package domain.generator;

import domain.*;

import java.util.List;

public class ManualLotto implements LottosGenerator {
    List<LottoNo> lottoNos;

    public ManualLotto(List<LottoNo> lottoNos) {
        this.lottoNos = lottoNos;
    }

    @Override
    public Lotto generate() {
        return new Lotto(new LottoNumbers(this.lottoNos));
    }
}
