package com.lotto.controller;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.LottoWinningBonusNumber;
import com.lotto.domain.LottoWinningNumbers;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

public class LottoManager {

    public void control() {
        LottoGroup lottoGroup = createLottoGroup();
        OutputView.confirmBuyCount(lottoGroup.size());
        OutputView.buyLottoList(lottoGroup.lottoList());

        LottoWinningNumbers winningNumbers = createWinningNumbers();
        LottoWinningBonusNumber bonusNumber = createBonusNumber();

        OutputView.winningStatistics();
        LottoStatistics statistics = lottoGroup.statistics(winningNumbers, bonusNumber);
        OutputView.winningStatisticsDetail(statistics);
        OutputView.investment(statistics.yield());
    }

    private LottoWinningBonusNumber createBonusNumber() {
        LottoWinningBonusNumber bonusNumber;

        while (true) {
            OutputView.requireBonusNumbers();
            try {
                bonusNumber = LottoWinningBonusNumber.valueOf(InputView.inputDataFromConsole());
                break;
            } catch (RuntimeException exception) {
                OutputView.out(exception.getMessage());
                continue;
            }
        }
        return bonusNumber;


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

    private LottoWinningNumbers createWinningNumbers() {
        LottoWinningNumbers lottoWinningNumbers;

        while (true) {
            OutputView.requireWinningNumbers();
            try {
                lottoWinningNumbers = LottoWinningNumbers
                        .createLottoWinningNumbers(InputView.inputDataFromConsole());
                break;
            } catch (RuntimeException exception) {
                OutputView.out(exception.getMessage());
                continue;
            }
        }
        return lottoWinningNumbers;
    }
}
