package com.lotto.controller;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.WinningLotto;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

public class LottoManager {

    public void control() {
        LottoGroup lottoGroup = createLottoGroup();
        OutputView.confirmBuyCount(lottoGroup.size());
        OutputView.buyLottoList(lottoGroup.lottoList());

        WinningLotto winningLotto = createWinningLotto();

        OutputView.winningStatistics();
        LottoStatistics statistics = lottoGroup.statistics(winningLotto);
        OutputView.winningStatisticsDetail(statistics);
        OutputView.investment(statistics.yield());
    }

    private LottoGroup createLottoGroup() {
        LottoGroup lottoGroup;

        while (true) {
            OutputView.requireLottoPrice();
            try {
                lottoGroup = LottoGroup.createLottoGroup(InputView.inputDataFromConsole());
                break;
            } catch (RuntimeException exception) {
                OutputView.out(exception.getMessage());
                continue;
            }
        }
        return lottoGroup;
    }

    private WinningLotto createWinningLotto() {
        WinningLotto winningLotto;

        while (true) {
            OutputView.requireWinningNumbers();
            try {
                winningLotto = WinningLotto
                        .createWinningLotto(InputView.inputDataFromConsole());
                break;
            } catch (RuntimeException exception) {
                OutputView.out(exception.getMessage());
                continue;
            }
        }

        while (true) {
            OutputView.requireBonusNumbers();
            try {
                winningLotto.setBonusNumber(InputView.inputDataFromConsole());
                break;
            } catch (RuntimeException exception) {
                OutputView.out(exception.getMessage());
                continue;
            }
        }

        return winningLotto;
    }
}
