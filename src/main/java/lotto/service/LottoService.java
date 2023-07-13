package lotto.service;

import lotto.domain.*;
import lotto.util.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    public Lottos buyLotto(Money money, Lottos manualLotto, long manualCount) {
        long autoLottoCount = money.countLotto() - manualCount;
        validateLottoCount(autoLottoCount);
        List<Lotto> lottos = LongStream.range(0, autoLottoCount)
                .mapToObj(l -> RandomLottoGenerator.generateLotto())
                .collect(Collectors.toList());
        Lottos autoLottos = new Lottos(lottos);
        return manualLotto.combineLottos(autoLottos);
    }

    private void validateLottoCount(long autoLottoCount) {
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("수동으로 구매하는 로또의 수가 구매금액을 벗어났습니다.");
        }
    }

    public LottoResults matchWinningLotto(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.matchWinningNumbers(winningNumbers);
    }

    public ProfitRate profitRate(LottoResults lottoResults, Money money) {
        return money.findProfitRate(lottoResults.sumTotalPrize());
    }
}
