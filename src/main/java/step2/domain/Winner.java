package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";

    private List<Integer> winnerNums;
    private Ranks countOfRanks;
    private Double profit;


    public Winner(LottoTickets lottoTickets, String lastWeekWinningInput) {
        getWinner(lottoTickets, lastWeekWinningInput);

        countOfRanks = new Ranks();
        int lottoTicketsSize = lottoTickets.size();
        calculateProfit(lottoTicketsSize);
    }

    private Winner getWinner(LottoTickets lottoTickets, String lastWeekWinningInput) {
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
        profit = countOfRanks.calculateProfit(lottoTicketsSize);
    }

    public Double getProfit() {
        return this.profit;
    }

    public Ranks getCountOfRanks() {
        return this.countOfRanks;
    }
}
