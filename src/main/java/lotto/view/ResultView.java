package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String LOTTO_WINNING_RATE_MESSAGE = "총 수익률은 %.2f입니다.";

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

    public static void showLottoWinningRate(LottoResult lottoResult) {
        //총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String printLottoTicket = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + printLottoTicket + "]");
    }
}
