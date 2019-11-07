package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";
    public static final int LOTTO_PRICE = 1000;

    private List<Integer> winnerNums;
    private Map<Integer, Integer> countOfRanks = new HashMap<>();
    private Double profit;


    public Winner(LottoTickets lottoTickets, String lastWeekWinningInput) {
        getWinner(lottoTickets, lastWeekWinningInput);

        int lottoTicketsSize = lottoTickets.size();
        calculateProfit(lottoTicketsSize);
    }

    public Winner getWinner(LottoTickets lottoTickets, String lastWeekWinningInput) {
        winnerNums = splitWinningNums(lastWeekWinningInput);

        lottoTickets.getWinner(winnerNums, countOfRanks);

        return this;
    }

    private List<Integer> splitWinningNums(String lastWeekWinningInput) {
        String[] splitedWinningNums = lastWeekWinningInput.split(WINNING_NUM_DELIMITER);

        int numSize = splitedWinningNums.length;
        List<Integer> winningNums = new ArrayList<>();

        for (int i = 0; i < numSize; i++) {
            winningNums.add(Integer.parseInt(splitedWinningNums[i]));
        }

        return winningNums;
    }

    private void calculateProfit(int lottoTicketsSize) {
        int sum = 0;

        for (int matchCount : countOfRanks.keySet()) {
            int countOfMatchTicket = countOfRanks.get(matchCount);

            sum += Rank.getReward(matchCount) * countOfMatchTicket;
        }

        int purchaseAmount = lottoTicketsSize * LOTTO_PRICE;
        profit = Double.parseDouble(String.format("%.2f", sum / (double) purchaseAmount));
    }

    public Double getProfit() {
        return this.profit;
    }

    public Map<Integer, Integer> getCountOfRanks() {
        return this.countOfRanks;
    }
}
