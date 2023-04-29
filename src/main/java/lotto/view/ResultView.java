package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerStatistics;

import java.util.List;

public final class ResultView {

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static void showAvailableLottoCount(LottoTickets maunualLottoTickets, LottoTickets autoLottoTickets) {
        System.out.printf("%n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                maunualLottoTickets.size(),
                autoLottoTickets.size());
    }

    public static void showIssuedLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getTickets();
        tickets.forEach(System.out::println);
    }

    public static void showResult(WinnerStatistics winnerStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        LottoRank.getRankValues()
                .forEach(rank -> showRewards(rank, winnerStatistics.getCountByRank(rank)));
        showIncomeRate(winnerStatistics.getIncomeRate());
    }

    private static void showIncomeRate(double incomeRate) {
        StringBuilder sb = new StringBuilder(String.format("총 수익률은 %s입니다.", incomeRate));
        if (incomeRate < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(sb);
    }

    private static void showRewards(LottoRank lottoRank, Integer count) {
        System.out.println(toResultMessage(lottoRank, count));
    }

    private static String toResultMessage(LottoRank lottoRank, Integer count) {
        if (lottoRank.isSecond()) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개",
                    lottoRank.getMatchedCount(),
                    lottoRank.getReward(),
                    count);
        }
        return String.format("%d개 일치 (%d원)- %d개",
                lottoRank.getMatchedCount(),
                lottoRank.getReward(),
                count);
    }

}