package lottery;

import java.util.List;

public class LottoResults {

    private static final int PRIZE_OF_3_MATCH = 5000;
    private static final int PRIZE_OF_4_MATCH = 50000;
    private static final int PRIZE_OF_5_MATCH = 1500000;
    private static final int PRIZE_OF_6_MATCH = 2000000000;
    private List<LottoResult> lottoResults;
    private final int numberOf3MatchedTickets;
    private final int numberOf4MatchedTickets;
    private final int numberOf5MatchedTickets;
    private final int numberOf6MatchedTickets;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
        this.numberOf3MatchedTickets = getNumberOfNMatchedTicket(3);
        this.numberOf4MatchedTickets = getNumberOfNMatchedTicket(4);
        this.numberOf5MatchedTickets = getNumberOfNMatchedTicket(5);
        this.numberOf6MatchedTickets = getNumberOfNMatchedTicket(6);
    }

    public double getEarningRate() {
        return sumOfWinMoney() / (double) purchasedAmount();
    }

    private int purchasedAmount() {
        return lottoResults.size() * 1000;
    }

    private double sumOfWinMoney() {
        return PRIZE_OF_3_MATCH * numberOf3MatchedTickets +
            PRIZE_OF_4_MATCH * numberOf4MatchedTickets +
            PRIZE_OF_5_MATCH * numberOf5MatchedTickets +
            PRIZE_OF_6_MATCH * numberOf6MatchedTickets;
    }

    private int getNumberOfNMatchedTicket(int numberOfMatched) {
        return (int) lottoResults.stream()
            .filter(i -> i.isMatchedNNumbers(numberOfMatched))
            .count();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("당첨 통계\n");
        resultString.append("---------\n");
        resultString.append("3개 일치 (5000원)- " + numberOf3MatchedTickets + "개\n");
        resultString.append("4개 일치 (50000원)- " + numberOf4MatchedTickets + "개\n");
        resultString.append("5개 일치 (1500000원)- " + numberOf5MatchedTickets + "개\n");
        resultString.append("6개 일치 (2000000000원)- " + numberOf6MatchedTickets + "개\n");

        return resultString.toString();
    }
}
