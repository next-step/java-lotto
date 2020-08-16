package common;

public class StringResources {

    // common
    public static final String BRACKET_OPENER = "[";
    public static final String BRACKET_CLOSER = "]";
    public static final String LINE_FEED = "\n";

    // StringAdder
    public static final String ERR_NO_NEGATIVE = "음수를 넣지 마세요";
    public static final String ERR_ONLY_NUMBER = "구분자 사이에는 숫자만 입력할 수 있습니다.";

    public static final String CUSTOM_SEPARATOR_STARTER = "//";
    public static final String DEFAULT_SEPARATOR = BRACKET_OPENER + ",:";

    // Lotto
    public static final String MSG_BUY_MONEY = "구입금액을 입력해 주세요.";
    public static final String MSG_BUY_QUANTITY = "개를 구매했습니다.";
    public static final String MSG_WINNING_NUMBER = "지난 주 당첨번호를 입력해주세요.";
    public static final String MSG_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
    public static final String MSG_WINNING_STATUS = "당첨 통계";

    public static final String[] MSG_LOTTO_RESULT = new String[] {
            "3개 일치 (5000원)- ##개",
            "4개 일치 (50000원)- ##개",
            "5개 일치 (1500000원)- ##개",
            "5개 일치, 보너스볼 일치 (30000000원)- ##개",
            "6개 일치 (2000000000원)- ##개"
    };

    public static final String MSG_EARNINGS_RATE = "총 수익률은 ##입니다.";

    public static final String ERR_MUST_BUY = "금액은 0 이상의 정수만 입력해주세요.";
    public static final String ERR_WRONG_UNIT = "1000원 단위로만 입력해주세요.";
    public static final String ERR_DUPLICATE_NUMBER = "중복되지 않은 6개의 번호로 구성해주세요.";
    public static final String ERR_WRONG_RANGE_NUMBER = "1 이상 45 이하의 수만 사용할 수 있습니다.";
    public static final String ERR_WRONG_RANGE_RESULT_NUMBER = "0 이상 6 이하의 수만 사용할 수 있습니다.";
    public static final String ERR_NO_LOTTO_LIST = "로또를 구매하지 않았습니다.";
    public static final String ERR_WRONG_RESULT_INPUT = "당첨번호는 ', '으로 구분하여 총 6개 입력해야 합니다.";

    public static final String LINE_SEPARATOR = "---------";
}
