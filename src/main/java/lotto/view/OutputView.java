package lotto.view;

import lotto.dto.LottoTicketDTO;
import lotto.dto.LottoTicketCntDTO;
import lotto.dto.ScoreBoardData;
import lotto.dto.ScoreData;

import java.util.stream.Collectors;

public class OutputView {
    private static final String TICKET_CNT_FMT = "%d개를 구매했습니다.\n";
    private static final String TICKET_DELIMITER = ", ";
    private static final String TICKET_FMT = "[%s]\n";

    private static final String SCORE_BOARD_TITLE_MSG = "당첨 통계";
    private static final String SCORE_BOARD_DELIMITER_MSG = "---------";
    private static final String SCORE_BOUNS_DESCRIBE_MSG = ", 보너스 볼 일치";
    private static final String SCORE_MATCH_COUNT_DESCRIBE_MSG = "개 일치";
    private static final String SCORE_FMT = "%d%s (%d원) - %d개\n";

    private static final String PROFIT_FMT = "총 수익률은 %.2f 입니다.";

    public void printTicketCnt(LottoTicketCntDTO dto) {
        System.out.format(TICKET_CNT_FMT, dto.getTicketCnt());
    }

    public void printTicket(LottoTicketDTO dto) {
        System.out.format(
            TICKET_FMT,
            dto.getLottoNumbers().stream().map(
                Object::toString
            ).collect(
                Collectors.joining(TICKET_DELIMITER)
            )
        );
    }

    public void printScoreBoardData(ScoreBoardData scoreBoardData) {
        System.out.println(SCORE_BOARD_TITLE_MSG);
        System.out.println(SCORE_BOARD_DELIMITER_MSG);

        for (ScoreData score : scoreBoardData.getScores()) {
            System.out.format(
                SCORE_FMT,
                score.getMatchedCnt(),
                getScoreDescribeMsg(score.getIsBoundMatched()),
                score.getReward(),
                score.getScoreCnt()
            );
        }

        System.out.format(PROFIT_FMT, scoreBoardData.getProfit());
    }

    private String getScoreDescribeMsg(boolean isBonusMatched) {
        String msg = SCORE_MATCH_COUNT_DESCRIBE_MSG;
        if (isBonusMatched) {
            msg += SCORE_BOUNS_DESCRIBE_MSG;
        }
        return msg;
    }
}
