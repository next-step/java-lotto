package lotto.application;

import common.model.Number;

public class Constant {

    public static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MESSAGE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MESSAGE_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public static final String OUTPUT_MESSAGE_PURCHASE_LOTTO_FORMAT = "%d개를 구매했습니다.";
    public static final String OUTPUT_MESSAGE_PURCHASE_MIX_LOTTO_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String OUTPUT_MESSAGE_REPORT_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String OUTPUT_MESSAGE_REPORT_SECOND_FORMAT = "5개 일치, 보너스 볼 일치(30000000원) - %d개";
    public static final String OUTPUT_MESSAGE_CALCULATE_RATE_OF_REVENUE_FORMAT = "총 수익률은 %.2f 입니다.";

    public static final String EXCEPTION_MESSAGE_LENGTH_VALIDATION = "당첨 번호가 6개가 아닙니다.";
    public static final String EXCEPTION_MESSAGE_DUPLICATE_VALIDATION = "중복되는 당첨 번호가 있습니다.";
    public static final String EXCEPTION_MESSAGE_RANGE_VALIDATION = "로또 번호는 1~45 사이의 숫자입니다.";
    public static final String EXCEPTION_MESSAGE_PARSE_VALIDATION = "숫자가 아닌 문자가 입력되었습니다.";

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final Number LOTTO_SECOND_AND_THIRD_MATCH_COUNT = new Number(5);

    private Constant() {
    }

}
