package lotto.domain;

import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.DuplicatedLottoException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Lotto {
    public static final int SIZE = 6;

    private final List<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNos) {
        validateLottoNos(lottoNos);
        this.lottoNos = new LinkedList<>();
        Collections.sort(lottoNos);
        for (int no : lottoNos) {
            add(no);
        }
    }

    int getCountOfMatch(Lotto lotto) {
        return (int) lotto.lottoNos.stream()
                .filter((lottoNo) -> contains(lottoNo))
                .count();
    }

    boolean contains(LottoNo lottoNo) {
        return lottoNos.contains(lottoNo);
    }

    private void add(int lottoNo) {
        LottoNo lottoNoObj = LottoNoPool.getLottoNo(lottoNo);
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
