package study.step4.view;

import study.step4.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";
    private static final String STRING_BONUS = ", 보너스 볼 일치";
    private static final String STRING_EMPTY = "";
    private static final String INPUT_RESULT_MANUAL_MESSAGE = "수동으로 ";
    private static final String INPUT_RESULT_AUTO_MESSAGE = "장, 자동으로 ";
    private static final String STRING_PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    private static final String STRING_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String TOTAL_START_MESSAGE = "총 수익률을 ";
    private static final String TOTAL_END_MESSAGE = "입니다. ";
    private static final String MATCH_START_MESSAGE = "개 일치 ";
    private static final String MATCH_START_BRACKET_MESSAGE = "(";
    private static final String MATCH_END_BRACKET_MESSAGE = ") - ";
    private static final String MATCH_END_MESSAGE = "개";
    private static final String ENTER = "\n";
    private static final int DEFAULT_LOTTO_YIELD = 1;
    private static final int MISS_MATCH_REMOVE_NUMBER = 0;

    private final LottoTickets lottoTickets;

    public ResultView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void printLottoTicketInfos(int manualNumber) {
        StringBuilder sb = new StringBuilder();
        List<LottoTicket> tickets = lottoTickets.readOnlyLottoTicket();
        sb.append(INPUT_RESULT_MANUAL_MESSAGE + manualNumber + INPUT_RESULT_AUTO_MESSAGE + (lottoTickets.lottoQuantity() - manualNumber) + BUY_QUANTITY_MESSAGE + ENTER);
        tickets.stream()
                .forEach(ticket -> sb.append(ticket.readOnlyLottoNumber().toString() + ENTER));
        System.out.println(sb);
    }

    public void printLottoResultInfos(LottoTickets lottoTickets, LottoWinners lottoWinners) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_WINNER_RANK + ENTER);
        sb.append(RESULT_WINNER_LINE);
        System.out.println(sb);
        Arrays.asList(LottoRank.values())
                .stream()
                .forEach(lottoRank -> printLottoRank(lottoRank, lottoWinners));

        printLottoYield(lottoTickets, lottoWinners);
    }

    public void printLottoYield(LottoTickets lottoTickets, LottoWinners lottoWinners) {
        StringBuilder sb = new StringBuilder();
        double yield = LottoYield.operationYield(lottoTickets, lottoWinners);
        sb.append(TOTAL_START_MESSAGE + String.format("%.2f", yield) + TOTAL_END_MESSAGE);

        if (yield >= DEFAULT_LOTTO_YIELD) {
            sb.append(STRING_PROFIT_MESSAGE);
            return;
        }
        sb.append(STRING_LOSS_MESSAGE);
        System.out.println(sb);
    }

    private void printLottoRank(LottoRank lottoRank, LottoWinners lottoWinners) {
        if (lottoRank.countOfMatch != MISS_MATCH_REMOVE_NUMBER) {
            System.out.println(lottoRank.countOfMatch + MATCH_START_MESSAGE + bonusOfString(lottoRank) + MATCH_START_BRACKET_MESSAGE + lottoRank.winningMoney + MATCH_END_BRACKET_MESSAGE + lottoRank.winnerCount(lottoTickets.readOnlyLottoTicket(), lottoWinners) + MATCH_END_MESSAGE);
        }
    }

    private String bonusOfString(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return STRING_BONUS;
        }
        return STRING_EMPTY;
    }
}
