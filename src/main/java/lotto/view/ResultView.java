package lotto.view;

import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.LottoTicketBundle;

import java.util.Arrays;

public class ResultView {

    public void printLottoTicketCounts(int manualLottoTicketCount, int autoLottoTicketCount) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.\n", manualLottoTicketCount, autoLottoTicketCount);
    }

    public void printUserLottoTickets(LottoTicketBundle userLottoTickets) {
        userLottoTickets.getLottoTickets().stream()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
    }

    public void printLottoResult(LottoResult lottoResult, int payAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.BAD)
                .forEach(rank -> {
                    String message = buildRankMessage(rank, lottoResult.getCount(rank));
                    System.out.println(message);
                });

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", lottoResult.getProfitRate());
    }

    private String buildRankMessage(LottoRank rank, int count) {
        String messageFormat = "%d개 일치%s (%d원)- %d개";
        String bonusPart = rank == LottoRank.FIVE_BONUS ? ", 보너스 볼 일치" : "";
        return String.format(messageFormat, rank.getMatchCount(), bonusPart, rank.getWinningPrize(), count);
    }
}
