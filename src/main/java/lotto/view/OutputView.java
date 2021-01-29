package lotto.view;

import lotto.LottoScore;
import lotto.domain.LottoTicket;
import lotto.dto.LottoTicketCntDTO;
import lotto.dto.LottoTicketDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String TICKET_CNT_FMT = "%d개를 구매했습니다.\n";
    private static final String TICKET_DELIMITER = ", ";
    private static final String TICKET_FMT = "[%s]\n";

    private static final String RESULT_TITLE_MSG = "당첨 통계";
    private static final String RESULT_DELIMITER_MSG = "---------";
    private static final String RESULT_MATCH_COUNT_DESCRIBE_MSG = "개 일치";
    private static final String RESULT_BOUNS_DESCRIBE_MSG = ", 보너스 볼 일치";

    private static final String RESULT_SCORE_FMT = "%d%s (%d원) - (%d)개";
    private static final String RESULT_PROFIT_PERCENT_FMT = "총 수익률은 %.2f 입니다.";

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

    private String getDescribeMsg(boolean isBonusMatched) {
        String msg = RESULT_MATCH_COUNT_DESCRIBE_MSG;
        if (isBonusMatched) {
            msg += RESULT_BOUNS_DESCRIBE_MSG;
        }
        return msg;
    }
}
