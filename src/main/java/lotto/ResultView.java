package lotto;

import java.util.Map;

public class ResultView {
    public String printTotalLottoTicketCount(int totalLottoTicketCount) {
        return totalLottoTicketCount + "개를 구매했습니다.";
    }

    public int printTotalResult(Map<Integer, Integer> matchingResult) {
        int totalPrizeMoney = 0;
        for (int i = 3; i <= 6; i++) {
            int matchingTicketCount = matchingResult.getOrDefault(i, 0); // 기본값 0L
            long prize = PrizePolicy.fromMatchCount(i);
            System.out.println(i + "개 일치 - (" + prize + "원) - " + matchingTicketCount + "개");

            totalPrizeMoney += prize * matchingTicketCount;
        }
        return totalPrizeMoney;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 "+ rateOfReturn +"입니다.");
    }

}
