package lotto.domain;

import lotto.ui.PrintView;
import random.LottoGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class Lotto {
    private TryLottoCount tryLottoCount;
    private LottoNumberList lottoNumberList;

    public Lotto(TryLottoCount tryLottoCount) {
        this(tryLottoCount,new LottoNumberList(new ArrayList<>()));
    }
    public Lotto(TryLottoCount tryLottoCount, LottoNumberList lottoNumberList) {
        this.tryLottoCount = tryLottoCount;
        this.lottoNumberList = new LottoNumberList(new ArrayList<>());
    }

    public static Lotto InitLotto(int purchaseAmount, LottoGenerator lottoGenerator) {
        Lotto lotto = new Lotto(new TryLottoCount(0));
        lotto.convertPurchaseToLottoTryCount(purchaseAmount);
        lotto.makeLottoList(lottoGenerator);
        lotto.printLottoList();
        return lotto;
    }

    public void convertPurchaseToLottoTryCount(int purchaseAmount) {
        PrintView.printLottoTryCount(tryLottoCount.calculateLottoTryCount(purchaseAmount));
    }

    public void makeLottoList(LottoGenerator lottoGenerator) {
        for (int i = 0; i < tryLottoCount.currentCount(); i++) {
            lottoNumberList.add(new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy()));
        }
    }

    public void printLottoList() {
        lottoNumberList.printLottoList();
    }

    public void searchWinningCount(LottoWinner lottoWinner) {
        lottoNumberList.searchWinningCount(lottoWinner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(tryLottoCount, lotto.tryLottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryLottoCount);
    }


}
