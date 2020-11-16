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
    public static final String INPUT_WINNING_MAXIMUM_NUM = "당첨번호 45이하의 수여야 합니다.";

    public static final String LOTTO_BEFORE_PRESENT_WINNING = "아직 로또 당첨 발표 전입니다.";

    public static final String LOTTO_RANK_ILLEGAL_MATCH_COUNT = "유효하지 않은 matchCount 값입니다.";
}
