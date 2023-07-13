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

    private void validateBuyLotto(Lottos manualLotto, long autoLottoCount, long manualLottoCount) {
        validateLottoCount(autoLottoCount);
        validateManualLottosSize(manualLotto, manualLottoCount);
    }

    private void validateLottoCount(long autoLottoCount) {
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("수동으로 구매하고자 하는 로또 금액이 총 금액을 초과했습니다. 초과한 로또 개수: " + Math.abs(autoLottoCount));
        }
    }

    private void validateManualLottosSize(Lottos manualLotto, long manualCount) {
        if (manualLotto.size() != manualCount) {
            throw new IllegalArgumentException(
                    "수동 로또 구매를 원하는 수와 실제 수동 로또로 입력한 값의 크기가 다릅니다. 수동 로또로 입력한 로또의 개수: "
                            + manualLotto.size() + "수동 로또 구매를 원하는 수: " + manualCount
            );
        }
    }

    public LottoResults matchWinningLotto(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.matchWinningNumbers(winningNumbers);
    }

    public ProfitRate profitRate(LottoResults lottoResults, Money money) {
        return money.findProfitRate(lottoResults.sumTotalPrize());
    }
}
