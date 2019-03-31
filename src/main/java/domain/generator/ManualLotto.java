package domain.generator;

import domain.*;

import java.util.List;

public class ManualLotto implements LottosGenerator {
    List<Integer> lottoNos;

    public ManualLotto(List<Integer> lottoNos) {
        this.lottoNos = lottoNos;
    }

    @Override
    public Lotto generate() {
        return new Lotto(LottoNumbers.convertToLottoNo(this.lottoNos));
    }
}
