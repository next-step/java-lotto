package lotto.domain;

import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.DuplicatedLottoException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Lotto {
    public static final int SIZE = 6;
    private static final Money price = new Money(1000);

    private final List<LottoNo> lottoNos;
    private final LottoNoPool lottoNoPool;

    public Lotto(List<Integer> lottoNos) {
        validateLottoNos(lottoNos);
        this.lottoNos = new LinkedList<>();
        lottoNoPool = LottoNoPool.getInstance();
        Collections.sort(lottoNos);
        for (int no : lottoNos) {
            add(no);
        }
    }

    public static int getNumOfLottos(Money purchaseMoney) {
        return (int) purchaseMoney.divide(price);
    }
    
    Rank getRank(Lotto winningLotto, LottoNo bonus) {
        return Rank.valueOf(
                getCountOfMatch(winningLotto)
                , lottoNos.contains(bonus)
        );
    }

    int getCountOfMatch(Lotto lotto) {
        int count = 0;
        for (LottoNo lottoNo : lotto.lottoNos) {
            count += lottoNos.contains(lottoNo) ? 1 : 0;
        }
        return count;
    }

    private void add(int lottoNo) {
        LottoNo lottoNoObj = lottoNoPool.getLottoNo(lottoNo);
        throwIfDuplicated(lottoNoObj);
        lottoNos.add(lottoNoObj);
    }

    private void validateLottoNos(List<Integer> lottoNos) {
        if (lottoNos.size() != SIZE) {
            throw BadNumOfLottoNoException.getInstance();
        }
    }

    private void throwIfDuplicated(LottoNo lottoNo) {
        if (lottoNos.contains(lottoNo)) {
            throw DuplicatedLottoException.getInstance();
        }
    }

    @Override
    public String toString() {
        return lottoNos.toString();
    }
}
