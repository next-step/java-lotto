package lotto.exception;

import static lotto.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.number.LottoNumber.MIN_LOTTO_NUMBER;

public class LottoIllegalArgumentException extends RuntimeException {
    public static final LottoIllegalArgumentException INVALID_PARSE_TO_INT = new LottoIllegalArgumentException("숫자로 변환할 수 없는 입력 값입니다.");
    public static final LottoIllegalArgumentException INVALID_MANUAL_LOTTO_COUNT = new LottoIllegalArgumentException("금액이 부족하여 수동 로또 개수를 원하는 수 만큼 구매할 수 없습니다.");
    public static final LottoIllegalArgumentException INVALID_LOTTO_NUMBERS_COUNT = new LottoIllegalArgumentException("로또 번호는 6개 입니다.");
    public static final LottoIllegalArgumentException INVALID_LOTTO_NUMBERS_RANGE = new LottoIllegalArgumentException("로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다.");
    public static final LottoIllegalArgumentException DUPLICATED_BONUS_NUMBER = new LottoIllegalArgumentException("보너스 숫자는 당첨 숫자에 포함된 수를 사용할 수 없습니다.");
    public static final  LottoIllegalArgumentException NEGATIVE_AMOUNT = new LottoIllegalArgumentException("금액은 음수가 될 수 없습니다.");
    public static final  LottoIllegalArgumentException NEGATIVE_COUNT = new LottoIllegalArgumentException("횟수는 음수가 될 수 없습니다.");


    private LottoIllegalArgumentException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
