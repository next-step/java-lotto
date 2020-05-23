package lotto.exception;

public class ErrorMessage {

    public static final String NULL_VALUE = "입력값이 null 입니다.";
    public static final String DUPLICATED_NUMBERS = "중복된 숫자가 포함되어 있습니다.";
    public static final String REQUIRED_SIZE_OF_LOTTO_NUMBERS = "로또 숫자는 %d개 여야 합니다.";
    public static final String RANGE_OF_LOTTO_NUMBER = "%d ~ %d 사이의 숫자가 아닙니다.";
    public static final String RANGE_OF_PRIZE_COUNT = "상금을 구할 수 있는 개수가 아닙니다.";
    public static final String REQUIRED_MIN_PRICE = "최소 금액 %d원이 필요합니다";
    public static final String NOT_ALLOW_NEGATIVE_NUMBER = "음수는 허용하지 않습니다. [input: '%d']";
    public static final String DUPLICATED_BONUS_NUMBER = "중복된 보너스 번호는 입력할 수 없습니다.";
    public static final String TICKET_COUNT_EXCEED = "구입 금액보다 수동으로 구매한 티켓 수가 더 많습니다.";

    private ErrorMessage() {
    }
}
