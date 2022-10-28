package lotto.view;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.LottoTicketDto;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String COUNT_MESSAGE = NEXT_LINE + "수동으로 %d장, 자동으로 %d장을 구매했습니다." + NEXT_LINE;
    private static final String WINNING_STATISTICS_MESSAGE = NEXT_LINE + "당첨 통계" + NEXT_LINE + "--------------------";
    private static final String LOTTO_MATCH_MESSAGE = "%d개 일치";
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_MATCH_RESULT_MESSAGE = " (%d원) - %d개" + NEXT_LINE;
    private static final String WINNING_RATE_MESSAGE = NEXT_LINE + "총 수익률은 %.2f 입니다. (기준은 1입니다. 1보다 크면 이득, 1보다 작으면 손해)";

    private ResultView() {
    }

    public static void showLottoCount(LottoCount lottoCount, LottoCount manualCount) {
        System.out.printf(COUNT_MESSAGE, manualCount.number(), lottoCount.findAbsoluteValue(manualCount));
    }

    public static void showLottoTicket(LottoTicket lottoTicket) {
        List<LottoDto> lottos = new LottoTicketDto(lottoTicket).lottoTicket();
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.numbers().toString());
        }
    }

    public static void printWinning(LottoWinning winning) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .forEach(rank -> printWiningResult(winning, rank));
    }

    public static void printWinningRate(LottoWinning winning, LottoAmount lottoAmount) {
        System.out.printf(WINNING_RATE_MESSAGE, lottoAmount.calcAmountRate(winning.sumWinningMoney()));
    }

    private static void printWiningResult(LottoWinning winning, LottoRank rank) {
        System.out.printf(LOTTO_MATCH_MESSAGE, rank.getCountOfMatch());
        if (rank == LottoRank.SECOND) {
            System.out.print(BONUS_MATCH_MESSAGE);
        }
        System.out.printf(LOTTO_MATCH_RESULT_MESSAGE, rank.winningMoneyPerRank(), winning.count(rank));
    }
}
