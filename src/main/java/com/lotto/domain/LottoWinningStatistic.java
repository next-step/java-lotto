package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;
import com.lotto.view.LottoStatisticView;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LottoWinningStatistic {

    private Map<LottoWinningType, Integer> lottoWinningList;
    private LottoStatisticView lottoStatisticView;

    public LottoWinningStatistic() {
        this.lottoWinningList = new TreeMap<>();
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

    public void calculateLottoWinningStatics(Lotto lotto, LottoWinningNumbers lottoWinningNumbers, LottoBonusBall lottoBonusBall) {
        Integer numberOfMatchingWithWinningNumber = lotto.getNumberOfMatchingWithWinningNumber(lottoWinningNumbers.getNumbers());
        Integer numberOfMatchingWithBonusNumber = lottoBonusBall.getNumberOfMatchingWithBonusNumber(lotto.getExtractedLottoNumbers());
        LottoWinningType lottoWinningType = LottoWinningType.getLottoWinningType(numberOfMatchingWithWinningNumber, numberOfMatchingWithBonusNumber);

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

        return winningAmount / inputAmount;
    }

    public void viewLottoRateOfReturn(Double rate) {
        this.lottoStatisticView.viewRateOfReturn(rate);
    }
}
