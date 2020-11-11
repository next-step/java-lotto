package lotto.domain;
import lotto.lib.LottoNoValidator;

public class LottoNo {

    /**
     * NOTE: Integer 클래스의 기능을 미래에 활용할지 모르므로,
     * primitive int 보다는, 클래스로 선언한다.
     */
    Integer lottoNo;

    public LottoNo(int lottoNo) {
        LottoNoValidator.validateLottoNo(lottoNo);
        this.lottoNo = lottoNo;
    }

    public LottoNo(String lottoNo) {
        LottoNoValidator.validateLottoNo(lottoNo);
        this.lottoNo = Integer.parseInt(lottoNo);
    }

    public int getNo() {
        return lottoNo;
    }

    @Override
    public String toString() {
        return lottoNo.toString();
    }
}
