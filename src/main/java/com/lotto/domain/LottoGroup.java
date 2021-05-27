package com.lotto.domain;

import com.lotto.exception.LottoPriceNumberFormatException;
import com.lotto.exception.LottoPriceOutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    private LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoGroup createLottoGroup(RequestPurchaseLotto requestPurchaseLotto)
            throws LottoPriceNumberFormatException, LottoPriceOutOfBoundsException {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < requestPurchaseLotto.getManualLottoCount(); i++) {
            lottoList.add(requestPurchaseLotto.getLottoList().get(i));
        }

        for (int i = 0; i < requestPurchaseLotto.getAutoLottoCount(); i++) {
            lottoList.add(LottoAutoGenerator.generate());
        }

        return new LottoGroup(lottoList);
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> lottoList() {
        return this.lottoList;
    }

    public LottoStatistics statistics(WinningLotto winningLotto) {
        List<LottoReward> lottoRewards = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            lottoRewards.add(winningLotto.reward(lotto));
        }

        return LottoStatistics.createLottoStatistics(lottoRewards);
    }
}
