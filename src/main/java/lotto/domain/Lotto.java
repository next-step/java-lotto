package lotto.domain;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.DuplicatedLottoException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNo> lottoNos;
    private final LottoNoPool lottoNoPool;

    Lotto() {
        lottoNos = new LinkedList<>();
        lottoNoPool = LottoNoPool.getInstance();
    }

    int countSameNo(Lotto lotto) {
        int count = 0;
        for (LottoNo lottoNo : lotto.lottoNos) {
            if (lottoNos.contains(lottoNo)) {
                count++;
            }
        }
        return count;
    }

    void add(int lottoNo) {
        LottoNo lottoNoObj = lottoNoPool.getLottoNo(lottoNo);
        throwIfDuplicated(lottoNoObj);
        lottoNos.add(lottoNoObj);
        validateSize();
    }

    int getSize() {
        return lottoNos.size();
    }

    private void validateSize() {
        if (getSize() > LottoConst.NUM_OF_LOTTO_NO) {
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

    private String getSorted(List<LottoNo> original) {
        List<LottoNo> cloned = new LinkedList<>(original);
        Collections.copy(cloned, original);
        Collections.sort(cloned);
        return cloned.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return getSorted(lottoNos)
                .equals(getSorted(lotto.lottoNos));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getSorted(lottoNos)
        );
    }
}
