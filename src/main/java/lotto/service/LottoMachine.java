package lotto.service;

import lotto.domain.*;
import lotto.util.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public Lottos buyLotto(Money money, Lottos manualLottos) {
        LottosCount totalLottosCount = new LottosCount(money.countLotto());
        LottosCount manualLottosCount = new LottosCount(manualLottos.size());
        LottosCount autoLottosCount = totalLottosCount.subtract(manualLottosCount);

        Lottos autoLottos = generateAutoLotto(autoLottosCount);

        return manualLottos.combineLottos(autoLottos);
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
