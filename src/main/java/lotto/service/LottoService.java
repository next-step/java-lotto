package lotto.service;

import lotto.domain.*;

public class LottoService {

    public Lottos buyLotto(Money money, Lottos manualLotto, LottosCount manualLottosCount) {
        validateManualLottosSize(manualLotto, manualLottosCount);
        LottosCount autoLottoCount = manualLottosCount.findAnotherCount(money);
        Lottos autoLottos = new Lottos(autoLottoCount.generateRandomLottos());
        return manualLotto.combineLottos(autoLottos);
    }

    private void validateManualLottosSize(Lottos manualLotto, LottosCount manualLottosCount) {
        if (!manualLottosCount.isSameLottosCount(manualLotto.size())) {
            throw new IllegalArgumentException("수동 로또 구매를 원하는 수와 실제 수동 로또로 입력한 값의 크기가 다릅니다.");
        }
    }

    public LottoResults matchWinningLotto(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.matchWinningNumbers(winningNumbers);
    }

    public ProfitRate profitRate(LottoResults lottoResults, Money money) {
        return money.findProfitRate(lottoResults.sumTotalPrize());
    }
}
