package step3.utils;

public class Constant {

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_TICKET_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String TOTAL_TICKET_COUNT_MESSAGE(int manualTicketCount, int totalTicketCount){
        return "수동으로 " + manualTicketCount + "장, 자동으로 " + (totalTicketCount - manualTicketCount) + "개를 구매했습니다.";
    }
    public static final String WINNING_NUMBER_SEPERATOR = ",";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String WINNING_STATISTICS_DIVISION = "---------";
    public static final String WINNING_RESULT_MESSAGE = "개 일치";
    public static final String BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    public static final String PROFIT_RATIO = "총 수익률 : ";
    public static final String UNIT_COUNT = "개";
    public static final String UNIT_PRIZE = "원";
    public static final String DASH = "-";
    public static final String MANUAL_NUMBER_SEPERATOR = ",";
    public static final String PRIZE_WRAPPER(int prize){
        return "(" + prize + ")";
    }

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int ZERO = 0;
    public static final int COUNT_THREE = 3;
    public static final int COUNT_FOUR = 4;
    public static final int COUNT_FIVE = 5;
    public static final int COUNT_SIX = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_PRIZE_FIRST = 2000000000;
    public static final int LOTTO_PRIZE_SECOND = 30000000;
    public static final int LOTTO_PRIZE_THIRD = 1500000;
    public static final int LOTTO_PRIZE_FOURTH = 50000;
    public static final int LOTTO_PRIZE_FIFTH = 5000;

}
