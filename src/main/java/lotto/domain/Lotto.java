package lotto.domain;

import lotto.ui.PrintView;
import lotto.random.LottoGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class Lotto {
    private TryLottoCount tryLottoCount;
    private LottoNumberList lottoNumberList;
    private LottoWinner lottoWinner;

    public static Lotto InitLotto(int purchaseAmount, LottoGenerator lottoGenerator) {
        Lotto lotto = new Lotto(new TryLottoCount(0,purchaseAmount));
        lotto.convertPurchaseToLottoTryCount();
        lotto.makeLottoList(lottoGenerator);
        lotto.printLottoList();
        return lotto;
    }

    public Lotto(TryLottoCount tryLottoCount) {
        this(tryLottoCount,new LottoNumberList(new ArrayList<>()));
    }
    public Lotto(TryLottoCount tryLottoCount, LottoNumberList lottoNumberList) {
        this.tryLottoCount = tryLottoCount;
        this.lottoNumberList = lottoNumberList;
    }

    public void convertPurchaseToLottoTryCount() {
        PrintView.printLottoTryCount(tryLottoCount.calculateLottoTryCount());
    }

    public void makeLottoList(LottoGenerator lottoGenerator) {
        for (int i = 0; i < tryLottoCount.currentCount(); i++) {
            lottoNumberList.add(new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy()));
        }
    }

    public void printLottoList() {
        lottoNumberList.printLottoList();
    }

    public void insertWinningLottoNumber(LottoWinner lottoWinner) {
        this.lottoWinner = lottoWinner;
    }

    public void recordWinningCount() {
        lottoNumberList.recordWinningCount(lottoWinner);
    }

    public void printWinningCount() {
        lottoWinner.printWinningCount();
    }

    public int winningAmount() {
        return lottoWinner.winningAmount();
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
