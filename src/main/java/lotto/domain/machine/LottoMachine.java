package lotto.domain.machine;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumberStrategy;
import lotto.domain.lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int lottoCount;

    public LottoMachine(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public Lottery buyAuto(LottoNumberStrategy lottoNumberStrategy) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(lottoNumberStrategy.get());
        }
        return Lottery.of(lottoNumbers);
    }
}
