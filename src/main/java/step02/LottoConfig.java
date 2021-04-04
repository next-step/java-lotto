package step02;

public class LottoConfig {
    static final int NUMBER_RANGE_END = 45;
    static final int NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_MAX_COUNT = 6;
    static final int LOTTO_PRICE = 1000;

    static final int ZERO = 0;
    static final int ONE = 1;

    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String BUY_N_COUNT = "개를 구매하셨습니다.";
    static final String INPUT_LAST_WINNER_NUMBER = "지난주 당첨 번호를 입력해주세요.";
    static final String WINNER_AVG = "당첨 통계";

    static final String SEPARATOR_NUMBER = ", ";
    static final String LINE_BRAKE = "\n";
    static final String START_LOTTO_SYMBOL = "[";
    static final String END_LOTTO_SYMBOL = "]";

    static final String ERROR_OVER_MAX_NUMBER = "로또 숫자는 " + NUMBER_RANGE_END + "이하의 수를 입력해주세요.";
    static final String ERROR_OVER_MAX_NUMBER_COUNT = LOTTO_NUMBER_MAX_COUNT + "개 이하의 수를 입력해주세요.";

}
