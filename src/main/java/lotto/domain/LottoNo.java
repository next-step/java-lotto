package lotto.domain;

import lotto.exception.LottoNoException;

public class LottoNo {

    /**
     * NOTE: Integer 클래스의 기능을 미래에 활용할지 모르므로,
     * primitive int 보다는, 클래스로 선언한다.
     */
    Integer lottoNo;

    public LottoNo(int lottoNo) {
        this.lottoNo = lottoNo;
    }

    public LottoNo(String lottoNo) {
        if (lottoNo == null) {
            throw LottoNoException.getNpeException();
        }
        try {
            this.lottoNo = Integer.parseInt(lottoNo);
        } catch (Exception e) {
            throw LottoNoException.getNanException();
        }
    }
}
