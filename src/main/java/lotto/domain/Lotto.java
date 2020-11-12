package lotto.domain;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.DuplicatedLottoException;
import lotto.utils.validator.LottoNoValidator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * NOTE: LottoNo 의 일급 컬렉션
 * model 외부에서는 Lotto 만 접근가능하고,
 * LottoNo 과 LottoNoPool 에 직접 접근하는 일이 없어야 한다.
 */
public class Lotto {
    private List<LottoNo> lottoNos;

    protected Lotto() {
        lottoNos = new LinkedList<>();
    }

    protected int countSameNo(Lotto lotto) {
        int count = 0;
        for (LottoNo lottoNo : lotto.lottoNos) {
            if (lottoNos.contains(lottoNo)) {
                count++;
            }
        }
        return count;
    }

    protected int getSize() {
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

    /**
     * FIXME: 타입으로 인한 중복된 로직 제거
     * int 와 String 타입이 다름으로 인해 발생하는
     * 중복되는 로직을 제거할 방법은 없을까?
     */
    private LottoNo getLottoNo(int no) {
        LottoNoPool pool = LottoNoPool.getInstance();
        return pool.getLottoNo(no);
    }

    private LottoNo getLottoNo(String no) {
        LottoNoPool pool = LottoNoPool.getInstance();
        return pool.getLottoNo(no);
    }

    private void add(LottoNo lottoNo) {
        throwIfDuplicated(lottoNo);
        lottoNos.add(lottoNo);
        validateSize();
    }

    // NOTE: domain 바깥에서 add 를 막기 위해 protected 로 선언
    protected void add(int lottoNo) {
        LottoNoValidator.validateLottoNo(lottoNo);
        add(getLottoNo(lottoNo));
    }

    // NOTE: domain 바깥에서 add 를 막기 위해 protected 로 선언
    protected void add(String lottoNo) {
        LottoNoValidator.validateLottoNo(lottoNo);
        add(getLottoNo(lottoNo));
    }

    @Override
    public String toString() {
        return lottoNos.toString();
    }

    private String hashString(List<LottoNo> original) {
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
        return hashString(lottoNos)
                .equals(hashString(lotto.lottoNos));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                hashString(lottoNos)
        );
    }
}
