package lotto.exception;

public class LottoExceptionMessage {
    public static final String INVALID_MONEY_UNIT = "구입 금액은 1000원 단위여야 합니다. (로또 1개 - 1000원)";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1이상 45 이하의 숫자만 입력 가능합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = "당첨 로또 번호는 총 6개의 숫자를 입력 바랍니다.";
    public static final String RESULT_IS_NULL = "결과가 존재하지 않습니다.";
    public static final String INVALID_BONUS_NUMBER_DUPLICATION = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
