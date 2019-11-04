package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.view.LottoView;

import java.util.Map;

public class LottoMachine {

    // 상태를 제거하면 사이드 이펙트를 제거할 수 있다. 하지만, 기존의 상태를 활용했던 곳에 파라미터로 전달해줘야 하므로 파라미터 수가 늘어나게 된다. trade off?
    private void start(LottoView lottoView) {
        try {
            Money money = getMoney(lottoView);
            Lottos lottos = createLottoNumbers(lottoView, money);

            createLottoNumbers(lottoView, money);
            findWinningLotto(lottoView, money, lottos);
        } catch (NumberFormatException exception) {
            lottoView.showConvertNumberError();
            restart(lottoView);
        } catch (IllegalArgumentException exception) {
            lottoView.showErrorMessage(exception.getMessage());
            restart(lottoView);
        }
    }

    private void restart(LottoView lottoView) {
        lottoView.showRestartMessage();
        start(lottoView);
    }

    private Money getMoney(LottoView lottoView) {
       return new Money(lottoView.getMoney());
    }

    private Lottos createLottoNumbers(LottoView lottoView, Money money) {
        Lottos lottos = new Lottos(money.getLottoCount());
        lottoView.showLottoNumbers(lottos);

        return lottos;
    }

    private void findWinningLotto(LottoView lottoView, Money money, Lottos lottos) {
        Map<LottoRank, Long> rankGroup = lottos.getRankGroup(new Lotto(lottoView.getWinningLottoNumbers()));

        lottoView.showRankResult(rankGroup);
        lottoView.showProfitRate(money.getProfitRate(rankGroup));
    }
}
