package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {
    public void printLottoTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : tickets.getAll()) {
            System.out.println(ticket);
        }
    }

    public void printLottoTickets(LottoTickets manualTickets, LottoTickets autoTickets) {
        String headerForm = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다", manualTickets.size(), autoTickets.size());
        System.out.println(headerForm);

        for (LottoTicket ticket : manualTickets.getAll()) {
            System.out.println(ticket);
        }
        for (LottoTicket ticket : autoTickets.getAll()) {
            System.out.println(ticket);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.NONE) continue;
            int count = lottoResult.getWinningCountsByPrize()
                    .getOrDefault(prize, 0);
            System.out.println(buildFormat(prize, count));
        }

        double profitRate = lottoResult.getProfitRate();
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }

    private static String buildFormat(LottoPrize prize, int count) {
        int matchCount = prize.getMatchCount();
        int prizeMoney = prize.getPrize();

        String bonusText = prize.hasBonus() ? ", 보너스 볼 포함" : "";

        return String.format("%d개 일치%s (%s원) - %d개",
                matchCount,
                bonusText,
                formatWithComma(prizeMoney),
                count);
    }

    private static String formatWithComma(int amount) {
        return String.format("%,d", amount);
    }
}
