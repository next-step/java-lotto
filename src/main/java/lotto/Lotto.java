package lotto;

import random.LottoGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class Lotto {
    TryLottoCount tryLottoCount;
    LottoNumberList lottoNumberList;

    public Lotto(TryLottoCount tryLottoCount) {
        this(tryLottoCount,new LottoNumberList(new ArrayList<>()));
    }
    public Lotto(TryLottoCount tryLottoCount, LottoNumberList lottoNumberList) {
        this.tryLottoCount = tryLottoCount;
        this.lottoNumberList = new LottoNumberList(new ArrayList<>());
    }

    public static Lotto InitLotto() {
        return new Lotto(new TryLottoCount(0));
    }

    public int calculateLottoTryCount(int purchaseAmount) {
        return tryLottoCount.calculateLottoTryCount(purchaseAmount);
    }

    public void makeLottoList(LottoGenerator lottoGenerator) {
        for (int i = 0; i < tryLottoCount.currentCount(); i++) {
            lottoNumberList.add(new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy()));
        }
    }

    public void printLottoList() {
        lottoNumberList.printLottoList();
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

    public void runWinner(LottoWinner lottoWinner) {
        lottoNumberList.runWinner(lottoWinner);
    }
}
