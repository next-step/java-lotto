package lotto.service;

import lotto.domain.*;
import lotto.util.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public Lottos buyLotto(Money money, Lottos manualLotto) {
        LottosCount totalLottosCount = new LottosCount(money.countLotto());
        LottosCount manualLottosCount = new LottosCount(manualLotto.size());
        LottosCount autoLottoCount = totalLottosCount.subtract(manualLottosCount);

        Lottos autoLottos = generateAutoLotto(autoLottoCount);

        return manualLotto.combineLottos(autoLottos);
    }

    private Lottos generateAutoLotto(LottosCount autoLottosCount) {
        List<Lotto> autoLottos = autoLottosCount.makeLottosCountToLongStream()
                .mapToObj(l -> RandomLottoGenerator.generateLotto())
                .collect(Collectors.toList());
        return new Lottos(autoLottos);
    }

    public LottoResults matchWinningLotto(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.matchWinningNumbers(winningNumbers);
    }

    public ProfitRate profitRate(LottoResults lottoResults, Money money) {
        return money.findProfitRate(lottoResults.sumTotalPrize());
    }
}
