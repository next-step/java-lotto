package com.lotto.domain;

import com.lotto.exception.IllegalPriceException;
import com.lotto.exception.LottoPriceOutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    private LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoGroup createLottoGroup(String totalPrice) throws IllegalPriceException,
            LottoPriceOutOfBoundsException {
        int nTotalPrice = castIntTotalPrice(totalPrice);
        validateTotalPrice(nTotalPrice);

        int totalCount = nTotalPrice / Lotto.UNIT_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < totalCount; i++) {
            lottoList.add(LottoAutoGenerator.generate());
        }

        return new LottoGroup(lottoList);
    }

    private static int castIntTotalPrice(String totalPrice) throws IllegalPriceException {
        int nTotalPrice;
        try {
            nTotalPrice = Integer.parseInt(totalPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalPriceException(totalPrice);
        }
        return nTotalPrice;
    }

    private static void validateTotalPrice(int totalPrice) {
        if (totalPrice < Lotto.UNIT_PRICE) {
            throw new LottoPriceOutOfBoundsException(totalPrice);
        }
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> lottoList() {
        return this.lottoList;
    }

    public LottoStatistics statistics(LottoWinningNumbers winningNumbers, LottoWinningBonusNumber bonusNumber) {
        List<LottoReward> lottoRewards = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            lottoRewards.add(winningNumbers.reward(lotto, bonusNumber));
        }

        return LottoStatistics.createLottoStatistics(lottoRewards);
    }
}
