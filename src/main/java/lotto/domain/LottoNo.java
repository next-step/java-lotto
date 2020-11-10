package lotto.domain;

import lotto.asset.LottoNoConst;
import lotto.exception.LottoNoException;

public class LottoNo {

    /**
     * NOTE: Integer 클래스의 기능을 미래에 활용할지 모르므로,
     * primitive int 보다는, 클래스로 선언한다.
     */
    Integer lottoNo;

    public LottoNo(int lottoNo) {
        validateLottoNo(lottoNo);
        this.lottoNo = lottoNo;
    }

    public LottoNo(String lottoNo) {
        validateLottoNo(lottoNo);
        this.lottoNo = Integer.parseInt(lottoNo);
    }

    public int getLottoNo() {
        return lottoNo;
    }

    private void validateLottoNo(int lottoNo) {
        boolean badRange = lottoNo > LottoNoConst.LOTTO_NO_MAX
                || lottoNo < LottoNoConst.LOTTO_NO_MIN;
        if (badRange) {
            throw LottoNoException.getRangeException();
        }
    }

    private void validateLottoNo(String lottoNo) {
        if (lottoNo == null) {
            throw LottoNoException.getNpeException();
        }
        int num;
        try {
            num = Integer.parseInt(lottoNo);
        } catch (Exception e) {
            throw LottoNoException.getNanException();
        }
        validateLottoNo(num);
    }
}
