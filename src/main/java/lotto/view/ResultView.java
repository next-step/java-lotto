package lotto.view;

import lotto.domain.LottoAmount;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.dto.LottoDto;
import lotto.dto.LottoTicketDto;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final String COUNT_MESSAGE = "%d개를 구매했습니다." + NEXT_LINE;
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEXT_LINE + "--------------------";
    private static final String LOTTO_MATCH_MESSAGE = "%d개 일치";
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_MATCH_RESULT_MESSAGE = " (%d원) - %d개" + NEXT_LINE;
    private static final String WINNING_RATE_MESSAGE = NEXT_LINE + "총 수익률은 %.2f 입니다. (기준은 1입니다. 1보다 크면 이득, 1보다 작으면 손해)";

    private ResultView() {
    }

    public static void showLottoCount(int lottoCount) {
        System.out.printf(COUNT_MESSAGE, lottoCount);
    }

    public static void showAutoLottoTicket(LottoTicket lottoTicket) {
        List<LottoDto> lottos = new LottoTicketDto(lottoTicket).lottoTicket();
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.numbers().toString());
        }
    }

    public static void printWinning(LottoWinning winning) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .forEach(rank -> {
                    Integer count = winning.count(rank);
                    printWiningResult(count, rank);
                });
    }

    public static void printWinningRate(LottoWinning winning, LottoAmount lottoAmount) {
        System.out.printf(WINNING_RATE_MESSAGE, lottoAmount.calcWinningRate(winning.sumWinningMoney()));
    }

    private static void printWiningResult(Integer count, LottoRank rank) {
        System.out.printf(LOTTO_MATCH_MESSAGE, rank.getCountOfMatch());
        if (rank == LottoRank.SECOND) {
            System.out.printf(BONUS_MATCH_MESSAGE);
        }
        System.out.printf(LOTTO_MATCH_RESULT_MESSAGE, rank.getWinningMoney(), count);
    }
}
