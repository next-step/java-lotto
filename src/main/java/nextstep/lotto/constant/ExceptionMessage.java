package nextstep.lotto.constant;

public class ExceptionMessage {

    public static final String INVALID_INPUT_ONLY_NUMBER = "입력 문자열은 숫자이외의 값이 될수 없습니다.";
    public static final String INVALID_INPUT_ONLY_POSITIVE_NUMBER = "입력 문자열은 음수 가 될수 없습니다.";
    public static final String INVALID_INPUT_MANUAL_GREAT_THAN_TOTAL = "전체구입 갯수보다 수동 갯수가 더 많을 수는 없습니다.";
    public static final String INVALID_INPUT_MINIMUM_AMOUNT_FOR_BUY = "최소 구입금액은 1000원 입니다.";
    public static final String INVALID_INPUT_MINIMUM_MANUAL_AMOUNT_FOR_BUY = "수동 구입의 최소 갯수는 0개 입니다.";
    public static final String INVALID_INPUT_LOTTO_NUMBER_RANGE = "로또 번호의 범위는 1~45 사이입니다.";
    public static final String INVALID_LOTTO_NUMBER_SIZE = "로또번호는 중복되지 않는 6개의 숫자여야합니다.";
    public static final String INVALID_BONUS_NUMBER_CONTAINS_LOTTO_NUMBERS = "보너스 번호는 당첨번호 6개 이외의 숫자여야합니다.";
}
