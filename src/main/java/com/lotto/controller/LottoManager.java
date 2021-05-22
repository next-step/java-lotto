package com.lotto.controller;

import com.lotto.LottoNumberGenerator;
import com.lotto.domain.Lotto;
import com.lotto.domain.LottoGroup;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoManager {

    public void control() {
        int totalCount = inputPrice() / Lotto.UNIT_PRICE;
        LottoGroup lottoGroup = createLottoGroup(totalCount);
        OutputView.confirmBuyCount(totalCount);
        OutputView.buyLottoList(lottoGroup.lottoList());

        Set<Integer> winningNumbers = inputWinningNumbers();

        OutputView.winningStatistics();
        OutputView.winningStatisticsDetail(lottoGroup.winningLottoMap(winningNumbers));
        OutputView.investment(lottoGroup.yield(winningNumbers));
    }

    private Set<Integer> inputWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        boolean flag = true;
        while (flag) {
            OutputView.requireWinningNumbers();
            try {
                winningNumbers = InputView.inputWinningNumbers();
                flag = false;
            } catch (IllegalArgumentException exception) {
                flag = true;
            }
        }
        return winningNumbers;
    }

    private int inputPrice() {
        boolean flag = true;
        int inputPrice = 0;

        while (flag) {
            OutputView.requireLottoPrice();
            try {
                inputPrice = InputView.inputPrice();
                flag = false;
            } catch (IllegalArgumentException exception) {
                flag = true;
            }
        }
        return inputPrice;
    }

    public LottoGroup createLottoGroup(int totalCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < totalCount; i++) {
            List<Integer> randomNumbers = new ArrayList<>();
            randomNumbers.addAll(LottoNumberGenerator.generate());

            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
        }

        return new LottoGroup(lottoList);
    }
}
