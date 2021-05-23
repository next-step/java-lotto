package com.lotto.controller;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.LottoWinningNumbers;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

import java.util.HashSet;
import java.util.Set;

public class LottoManager {

    public void control() {
        LottoGroup lottoGroup = createLottoGroup();
        OutputView.confirmBuyCount(lottoGroup.size());
        OutputView.buyLottoList(lottoGroup.lottoList());

        LottoWinningNumbers winningNumbers = createWinningNumbers();

        OutputView.winningStatistics();
        LottoStatistics statistics = lottoGroup.statistics(winningNumbers);
        OutputView.winningStatisticsDetail(statistics);
        OutputView.investment(statistics.yield());
    }

    private LottoGroup createLottoGroup() {
        boolean flag = true;
        LottoGroup lottoGroup = null;

        while (flag) {
            OutputView.requireLottoPrice();
            try {
                lottoGroup = LottoGroup.createLottoGroup(InputView.inputPrice());
                flag = false;
            } catch (RuntimeException exception) {
                flag = true;
                OutputView.out(exception.getMessage());
            }
        }
        return lottoGroup;
    }

    private LottoWinningNumbers createWinningNumbers() {
        LottoWinningNumbers lottoWinningNumbers = null;

        boolean flag = true;
        while (flag) {
            OutputView.requireWinningNumbers();
            try {
                lottoWinningNumbers = LottoWinningNumbers
                        .createLottoWinningNumbers(InputView.inputWinningNumbers());
                flag = false;
            } catch (RuntimeException exception) {
                flag = true;
                OutputView.out(exception.getMessage());
            }
        }
        return lottoWinningNumbers;
    }
}
