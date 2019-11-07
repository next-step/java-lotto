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
            Money money = getMoney(lottoView);
            Lottos lottos = createLottoNumbers(lottoView, money);

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
        int totalLottoCount = money.getLottoCount();
        int manuallySelectedLottoCount = lottoView.getManuallySelectedLottoCount();
        int autoSelectedLottoCount = totalLottoCount - manuallySelectedLottoCount;

        List<Lotto> totalLottos = new ArrayList<>();
        totalLottos.addAll(createSelectedLotto(lottoView, manuallySelectedLottoCount));
        totalLottos.addAll(LottoProvider.createLottos(autoSelectedLottoCount));

        Lottos lottos = new Lottos(totalLottos);
        lottoView.showLottoNumbers(lottos, manuallySelectedLottoCount, autoSelectedLottoCount);

        return lottos;
    }

    private List<Lotto> createSelectedLotto(LottoView lottoView, int count) {
        lottoView.showSelectedLottoNumberQuestion();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoProvider.createLotto(lottoView.getNumbers()));
        }

        return lottos;
    }

    private void findWinningLotto(LottoView lottoView, Money money, Lottos lottos) {
        List<Integer> winningNumbers = lottoView.getWinningNumbers();
        int winningBonusNumber = lottoView.getWinningBonusNumber();
        WinningLotto winningLotto = LottoProvider.createWinningLotto(winningNumbers, winningBonusNumber);

        LottoRankGroup rankGroup = lottos.compareTo(winningLotto);

        lottoView.showRankResult(rankGroup);
        lottoView.showProfitRate(money.getProfitRate(rankGroup));
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
