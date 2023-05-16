package step2;

import java.util.Map;

public class LottoMessage {

    public static final String AMOUNT_MESSAGE_QUESTION = "구입금액을 입력해 주세요.";
    public static final String BONUS_MESSAGE_QUESTION = "보너스 볼을 입력해 주세요.";
    public static final String WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BOUGHT_LOTTO_TICKETS = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_SEPERATOR = ",";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String WINNING_STATISTICS_DIVISION = "---------";
    public static final String PROFIT_RATIO = "총 수익률은 ";
    public static final String SAME = "일치";
    public static final String UNIT_COUNT = "개";
    public static final String UNIT_PRIZE = "원";
    public static final String BLANK = " ";
    public static final String DASH = "-";
    public static final String END_MSG = "입니다.";
    public static final String BOUNUS_MSG = ", 보너스 볼 일치";

    public static final String PRIZE_WRAPPER(String prize) {
        return "(" + prize + ")";
    }

    public static final String SAME_NUM_WRAPPER(int prize) {
        int rank = LottoPrizeEnum.getRankByPrize(prize);
        String msg = LottoPrizeEnum.getCntByRank(rank) + LottoMessage.UNIT_COUNT + LottoMessage.BLANK + LottoMessage.SAME + LottoMessage.BLANK;
        if (rank == 2) msg += BOUNUS_MSG;

        return msg;
    }
}

