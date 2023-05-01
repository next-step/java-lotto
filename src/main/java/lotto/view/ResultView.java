package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String LOTTO_RANK2_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
    private static final String LOTTO_WINNING_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";

    public static void showLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(ResultView::printLottoTicket);
    }

    public static void showLottoWinningResult(LottoResult lottoPrizeResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoPrizeResult.getMatchesResult().forEach((lottoPrize, count) -> {
            System.out.printf(getLottoRankMessage(lottoPrize), lottoPrize.rankCount(), lottoPrize.money(), count);
        });
    }

    public static void showLottoWinningRate(LottoResult lottoResult, LottoTickets lottoTickets) {
        double winningRate = lottoResult.calculateRate(lottoTickets.size());
        System.out.printf(LOTTO_WINNING_RATE_MESSAGE, winningRate);
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String getLottoRankMessage(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.RANK2) {
            return LOTTO_RANK2_MESSAGE;
        }
        return LOTTO_RANK_MESSAGE;
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String printLottoTicket = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + printLottoTicket + "]");
    }
}
