package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";

    private Ranks countOfRanks;
    private Double profit;

    public Winner(LottoTickets lottoTickets, String lastWeekWinningInput, Bonus bonus) {
        countOfRanks = new Ranks();

        prepareWinner(lottoTickets, lastWeekWinningInput, bonus);
        getWinner();

        int lottoTicketsSize = lottoTickets.size();
        calculateProfit(lottoTicketsSize);
    }

    private void prepareWinner(LottoTickets lottoTickets, String lastWeekWinningInput, Bonus bonus) {
        List<Integer> winnerNums = splitWinningNums(lastWeekWinningInput);

        lottoTickets.prepareWinner(winnerNums, bonus, countOfRanks);
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

    private Winner getWinner() {
        return this;
    }

    private void calculateProfit(int lottoTicketsSize) {
        profit = countOfRanks.calculateProfit(lottoTicketsSize);
    }

    public Ranks getCountOfRanks() {
        return this.countOfRanks;
    }

    public String toStringProfit() {
        return this.profit.toString();
    }
}
