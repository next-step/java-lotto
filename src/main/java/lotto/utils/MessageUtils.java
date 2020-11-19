package lotto.utils;

public class MessageUtils {

    private MessageUtils() {
        throw new IllegalStateException(MessageUtils.UTILITY_CLASS);
    }

    public static final String UTILITY_CLASS = "Utility class";

    public static final String INPUT_MUST_NUMBER = "입력값은 숫자여야합니다.";
    public static final String INPUT_MORE_THAN_ZERO = "금액은 0원 이상이어야 합니다.";
    public static final String INPUT_MULTIPLE_1000 = "금액은 1000의 배수여야합니다.";

    public static final String INPUT_NOT_EMPTY = "입력값은 빈값일 수 없습니다.";
    public static final String INPUT_WINNING_SIZE = "당첨번호는 중복 없는 6자리여야 합니다.";
    public static final String INPUT_WINNING_INVALID_NUM = "당첨번호 1이상 45이하의 수여야 합니다.";
    public static final String INPUT_WINNING_BONUS_DUPLICATED = "보너스 숫자는 당첨번호에 없는 번호여야 합니다.";

    public static final String LOTTO_NUMBER_INVALID_NUM = "로또 숫자는 1이상 45이하의 수여야 합니다.";
}
