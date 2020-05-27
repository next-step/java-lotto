package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;
import com.lotto.view.LottoStatisticView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoWinningStatistic {

    private Map<LottoWinningType, Integer> lottoWinningList;
    private LottoStatisticView lottoStatisticView;

    public LottoWinningStatistic() {
        this.lottoWinningList = new HashMap<>();
        Arrays.stream(LottoWinningType.values()).forEach(type -> {
            if (!type.equals(LottoWinningType.NOTHING_CLASS)) {
                this.lottoWinningList.put(type, 0);
            }
        });
        this.lottoStatisticView = new LottoStatisticView();
    }

    public Map<LottoWinningType, Integer> getLottoWinningList() {
        return lottoWinningList;
    }

    public void calculateLottoWinningStatics(Lotto lotto, LottoWinningNumbers lottoWinningNumbers) {
        Integer numberOfMatchingWithWinningNumber = lotto.getNumberOfMatchingWithWinningNumber(lottoWinningNumbers.getNumbers());
        LottoWinningType lottoWinningType = LottoWinningType.getLottoWinningType(numberOfMatchingWithWinningNumber);

        if (lottoWinningType.equals(LottoWinningType.NOTHING_CLASS)) {
            return;
        }

        Integer currentCountOfWinningType = this.lottoWinningList.get(lottoWinningType);
        Integer increaseCountOfWinningType = currentCountOfWinningType + 1;

        this.lottoWinningList.put(lottoWinningType, increaseCountOfWinningType);
    }

    public void viewWinningStatistic() {
        this.lottoStatisticView.viewLottoStatistic(this.lottoWinningList);
    }

    public Double getLottoRateOfReturn(Integer purchaseCount) {
        Integer inputAmount = LottoViewHelper.getPurchaseAmountOfLotto(purchaseCount);
        Double winningAmount = 0.0;
        for (Map.Entry<LottoWinningType, Integer> entry : lottoWinningList.entrySet()) {
            LottoWinningType lottoWinningType = entry.getKey();
            Integer lottoWinningCount = entry.getValue();

            winningAmount += lottoWinningType.getWinningAmount() * lottoWinningCount;

        }

        return (Double) winningAmount / inputAmount;
    }

    public void viewLottoRateOfReturn(Long rate) {
        this.lottoStatisticView.viewRateOfReturn(rate);
    }
}
