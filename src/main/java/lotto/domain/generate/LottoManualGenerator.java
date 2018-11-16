package lotto.domain.generate;

import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;

import java.util.ArrayList;
import java.util.List;

public class LottoManualGenerator implements LottosGenerator {

    private List<String> lottoNumbers;

    public LottoManualGenerator() {
        this.lottoNumbers = new ArrayList<>();
    }
    public LottoManualGenerator(List<String> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public BundleLotto generate(LottoCountManager lottoCountManager, BundleLotto lottos) {
        for (String number : lottoNumbers) {
            lottos.addLotto(Lotto.manual(number));
        }
        return lottos;
    }
}
