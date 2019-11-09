package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static LottoMachine lottoMachine;

    private LottoMachine() {}

    public void start(LottoView lottoView) {
        try {
            Money money = new Money(lottoView.getMoney());
            Lottos lottos = createLottoNumbers(lottoView, money);

            LottoRankGroup rankGroup = findWinningLotto(lottoView, lottos);

            lottoView.showRankResult(rankGroup);
            lottoView.showProfitRate(money.getProfitRate(rankGroup));
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

    private Lottos createLottoNumbers(LottoView lottoView, Money money) {
        int totalLottoCount = money.getLottoCount();
        int manuallySelectedLottoCount = lottoView.getManuallySelectedLottoCount();
        int autoSelectedLottoCount = totalLottoCount - manuallySelectedLottoCount;

        lottoView.showSelectedLottoNumberQuestion();

        List<Lotto> totalLottos = new ArrayList<>();
        for (int i = 0; i < manuallySelectedLottoCount; i++) {
            totalLottos.add(LottoProvider.createLotto(lottoView.getNumbers()));
        }
        totalLottos.addAll(LottoProvider.createLottos(autoSelectedLottoCount));

        Lottos lottos = new Lottos(totalLottos);
        lottoView.showLottoNumbers(lottos, manuallySelectedLottoCount, autoSelectedLottoCount);

        return lottos;
    }

    private LottoRankGroup findWinningLotto(LottoView lottoView, Lottos lottos) {
        List<Integer> winningNumbers = lottoView.getWinningNumbers();
        int winningBonusNumber = lottoView.getWinningBonusNumber();
        WinningLotto winningLotto = LottoProvider.createWinningLotto(winningNumbers, winningBonusNumber);

        return lottos.compareTo(winningLotto);
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            synchronized (LottoMachine.class) {
                if (lottoMachine == null) {
                    lottoMachine = new LottoMachine();
                }
            }
        }

        return lottoMachine;
    }
}
