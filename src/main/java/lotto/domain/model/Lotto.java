package lotto.domain.model;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;

import java.util.LinkedList;
import java.util.List;

// NOTE: LottoNo 의 일급 컬렉션
public class Lotto {
    private List<LottoNo> lottoNos;

    public Lotto() {
        lottoNos = new LinkedList<>();
    }

    public int getSize() {
        return lottoNos.size();
    }

    private void validateSize() {
        if (getSize() > LottoConst.NUM_OF_LOTTO_NO) {
            throw BadNumOfLottoNoException.getInstance();
        }
    }

    private void add(LottoNo lottoNo) {
        lottoNos.add(lottoNo);
        validateSize();
    }

    // NOTE: domain 바깥에서 add 를 막기 위해 protected 로 선언
    protected void add(int lottoNo) {
        add(new LottoNo(lottoNo));
    }

    // NOTE: domain 바깥에서 add 를 막기 위해 protected 로 선언
    protected void add(String lottoNo) {
        add(new LottoNo(lottoNo));
    }
}
