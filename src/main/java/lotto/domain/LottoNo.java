package lotto.domain;

import lotto.exception.LottoNoException;
import lotto.lib.Validator;

import java.util.Optional;

public class LottoNo {

    /**
     * NOTE: Integer 클래스의 기능을 미래에 활용할지 모르므로,
     * primitive int 보다는, 클래스로 선언한다.
     */
    Integer lottoNo;

    public LottoNo(int lottoNo) {
        if (!validateLottoNo(lottoNo)) {
            throw LottoNoException.getSomeException();
        }
        this.lottoNo = lottoNo;
    }

    public LottoNo(String lottoNo) {
        if (!validateLottoNo(lottoNo)) {
            throw LottoNoException.getSomeException();
        }
        this.lottoNo = Integer.parseInt(lottoNo);
    }

    public int getLottoNo() {
        return lottoNo;
    }

    private boolean validateLottoNo(int lottoNo) {
        if (Validator.validateLottoRange(lottoNo)) {
            return true;
        }
        throw LottoNoException.getRangeException();
    }

    private boolean validateLottoNo(String lottoStr) {
        return Optional.ofNullable(lottoStr).map(lotto -> {
            if (Validator.validateNan(lotto)) {
                throw LottoNoException.getNanException();
            }
            return validateLottoNo(Integer.parseInt(lotto));
        }).orElseThrow(() -> LottoNoException.getNpeException());
    }
}
