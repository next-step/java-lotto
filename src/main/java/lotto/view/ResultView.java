package lotto.view;

import lotto.entity.Lottos;
import lotto.entity.PrizePolicy;

import java.util.Map;

public class ResultView {

    public static final int MIN_MATCH_COUNT = 3;

    public void printTotalLottoTicketCount(int totalLottoTicketCount) {
        System.out.println(totalLottoTicketCount + "개를 구매했습니다.");
    }

    public void printLottoTickets(Lottos totalLottoTickets) {
        totalLottoTickets.getValues().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public int printTotalResult(Map<PrizePolicy, Integer> matchingResult) {
        int totalPrizeMoney = 0;

        for (PrizePolicy prizePolicy : PrizePolicy.values()) {
            int matchingTicketCount = matchingResult.getOrDefault(prizePolicy, 0);
            int prize = prizePolicy.getPrize();
            int matchCount = prizePolicy.getMatchCount();
            if (matchCount >= MIN_MATCH_COUNT) {
                String bonusMessage = (prizePolicy == PrizePolicy.FIVE_BONUS) ? ", 보너스 볼 일치" : "";
                System.out.println(String.format("%d개 일치%s - (%d원) - %d개",
                                                  matchCount,
                                                  bonusMessage,
                                                  prize,
                                                  matchingTicketCount));
            }

            totalPrizeMoney += prize * matchingTicketCount;
        }

        return totalPrizeMoney;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }

}
