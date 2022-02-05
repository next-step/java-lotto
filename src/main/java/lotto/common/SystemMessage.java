package lotto.common;

public class SystemMessage {

    private SystemMessage() {
    }

    public static final String RANGE_EXCEPTION_MESSAGE = "복권의 숫자 범위가 유효하지 않습니다.";
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "복권에 중복된 숫자가 존재합니다.";
    public static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "복권의 숫자 개수가 유효하지 않습니다.";
    public static final String MIN_PURCHASE_EXCEPTION_MESSAGE = "최소 1000원이어야 합니다.";
    public static final String PER_THOUSAND_EXCEPTION_MESSAGE = "투입한 금액이 1000원 단위가 아닙니다.";
    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
}
