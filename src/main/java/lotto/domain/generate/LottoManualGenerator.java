package lotto.domain.generate;

import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;
import lotto.view.InputView;

import java.util.List;

public class LottoManualGenerator implements LottosGenerator {

    @Override
    public BundleLotto generate(LottoCountManager lottoCountManager, BundleLotto lottos) {
        List<String> lottoNumbers = InputView.getManualLottoNumbers(lottoCountManager);
        for (String number : lottoNumbers) {
            lottos.addLotto(Lotto.manual(number));
        }
        return lottos;
    }
}
