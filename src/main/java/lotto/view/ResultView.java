package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";
    private static final String STRING_BONUS = ", 보너스 볼 일치";
    private static final String STRING_EMPTY = "";

    private final LottoMachine lottoMachine;

    public ResultView(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void printLottoTicketInfos() {
        List<LottoTicket> tickets = lottoMachine.lottoTickets();

        System.out.println(lottoMachine.lottoQuantity() + BUY_QUANTITY_MESSAGE);

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.lottoNumber().toString()));
    }

    public void printLottoRanksInfos(LottoNumbers winnerNumber, LottoNumbers bounsNumber) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        Arrays.asList(LottoRank.values())
                .stream()
                .forEach(lottoRank -> printLottoRank(lottoRank, winnerNumber, bounsNumber));
    }

    public void printLottoYield(LottoYield lottoYield) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoYield.yield()) + "입니다.(기준이 1이기 때문에 결과적으로 " + lottoYield.stringYield() + "라는 의미임)");
    }

    public void printLottoRank(LottoRank lottoRank, LottoNumbers winnerNumber, LottoNumbers bonusNumber) {
        System.out.println(lottoRank.countOfMatch + "개 일치 " + bonusOfString(lottoRank) + "(" + lottoRank.winningMoney + ") - " + lottoRank.winnerCount(lottoMachine.lottoTickets(), winnerNumber, bonusNumber) + "개");
    }

    private String bonusOfString(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return STRING_BONUS;
        }

        return STRING_EMPTY;
    }
}
