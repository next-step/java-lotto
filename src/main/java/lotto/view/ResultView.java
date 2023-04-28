package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String LOTTO_WINNING_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";

    public static void showLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(ResultView::printLottoTicket);
    }

    public static void showLottoWinningResult(LottoResult lottoPrizeResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoPrizeResult.getMatchesResult().forEach((lottoPrize, count) -> {
            System.out.printf(LOTTO_RANK_MESSAGE, lottoPrize.rankCount(), lottoPrize.money(), count);
        });
    }

    public static void showLottoWinningRate(LottoResult lottoResult, int purchaseCount) {
        double winningRate = lottoResult.calculateRate(purchaseCount);
        System.out.printf(LOTTO_WINNING_RATE_MESSAGE, winningRate);
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String printLottoTicket = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + printLottoTicket + "]");
    }
}
