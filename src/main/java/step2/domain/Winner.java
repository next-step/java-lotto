package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";

    private Ranks ranks;
    private Double profit;

    public Winner(LottoTickets lottoTickets, String lastWeekWinningInput, Bonus bonus) {
        List<Integer> winnerNums = splitWinningNums(lastWeekWinningInput);

        ranks = new Ranks(lottoTickets, winnerNums, bonus);

        int lottoTicketsSize = lottoTickets.size();
        profit = calculateProfit(lottoTicketsSize);
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

    private Double calculateProfit(int lottoTicketsSize) {
        return ranks.calculateProfit(lottoTicketsSize);
    }

    public Ranks getRanks() {
        return this.ranks;
    }

    public String toStringProfit() {
        return this.profit.toString();
    }
}
