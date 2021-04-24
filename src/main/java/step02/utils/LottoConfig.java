package step02.utils;

public class LottoConfig {
    public static final int NUMBER_RANGE_END = 45;
    public static final int NUMBER_RANGE_START = 1;
    public static final int LOTTO_NUMBER_MAX_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int ONE_HUNDRED = 100;
    public static final double ONE_HUNDRED_D = 100.0;

    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_LAST_WINNER_NUMBER = "지난주 당첨 번호를 입력해주세요.";
    public static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public static final String REGEX = ",";
    public static final String BLANK = " ";
    public static final String NO_BLANK = "";
    public static final String LINE_BRAKE = "\n";
    public static final String START_LOTTO_SYMBOL = "[";
    public static final String END_LOTTO_SYMBOL = "]";

    public static final String ERROR_OVER_MAX_NUMBER = "로또 숫자는 " + NUMBER_RANGE_END + "이하의 수를 입력해주세요.";
    public static final String ERROR_OVER_MAX_NUMBER_COUNT = LOTTO_NUMBER_MAX_COUNT + "개의 수를 입력해주세요.";
    public static final String ERROR_MIN_PRICE = "최소 구매 금액은 " + LOTTO_PRICE + "원 입니다.";
    public static final String ERROR_OUT_OF_TOTAL_COUNT = "총 구매 수량보다 많습니다.";
    public static final String ERROR_INPUT_WINNER_NUMBER = "입력한 로또 숫자의 갯수(6개)와 중복여부를 체크해주세요.";

    public static final String RESULT_WINNER_AVG = "당첨 통계\n---------";
    public static final String RESULT_FIFTH = "3개 일치 (5000원)- %d개";
    public static final String RESULT_FORTH = "4개 일치 (50000원)- %d개";
    public static final String RESULT_THIRD = "5개 일치 (1500000원)- %d개";
    public static final String RESULT_SECOND = "5개 일치, 보너스 볼 일치(30000000원) - %d개";
    public static final String RESULT_FIRST = "6개 일치 (2000000000원)- %d개";
    public static final String RESULT_BUY_N_COUNT = "수동으로 %d장, 자동으로 %d장을 구매하셨습니다.";
    public static final String RESULT_TOTAL_YIELD = "총 수익률은 %.2f입니다.";
}
