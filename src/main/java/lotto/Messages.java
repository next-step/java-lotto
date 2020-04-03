package lotto;

public class Messages {
    public static final String MESSAGE_MONEY_INPUT = "구입금액을 숫자로 입력해 주세요.";
    public static final String MESSAGE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 갯수를 숫자로 입력해 주세요.";
    public static final String MESSAGE_LOTTO_MANUAL = "수동으로 구매할 로또 번호를 입력하세요. (쉼표로 번호 구분)";
    public static final String MESSAGE_WINNING_LOTTO = "지난 주 당첨번호를 입력하세요. (쉼표로 구분)";
    public static final String MESSAGE_BONUS_BALL = "지난 주 보너스 번호를 숫자로 입력하세요.";

    public static final String WARNING_INTEGER_FORMAT = "숫자만 입력 가능합니다.";
    public static final String WARNING_NULL_AND_EMPTY = "공백 또는 빈문자열은 입력할 수 없습니다.";
    public static final String WARNING_LOTTO_COUNT = "로또 금액이 부족합니다. 갯수를 다시 입력해 주세요.";

    public static final String WARNING_LOTTO_NUMBER_RANGE = "로또의 번호는 1이상 45이하의 숫자만 가능합니다.";
    public static final String WARNING_LOTTO_SIZE = "로또는 6개의 LottoNumber로 구성되어야 합니다.";
    public static final String WARNING_LOTTO_NON_DUPLICATION = "로또는 중복되지 않은 숫자로 구성되어야 합니다.";

    public static final String WARNING_BONUS_BALL_NOT_IN_LOTTO = "보너스 번호는 당첨 로또 번호에 포함되지 않아야 합니다.";
    public static final String WARNING_NOT_ENOUGH_TO_BUY = "로또는 1000원 이상부터 구매 가능합니다.";
}
