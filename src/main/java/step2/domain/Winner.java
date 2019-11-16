package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";

    private Ranks ranks;
    private Double profit;

    public Winner(Ranks ranks, Double profit) {
        this.ranks = ranks;
        this.profit = profit;
    }

    public Winner(LottoTickets lottoTickets, String lastWeekWinningInput, LottoNum bonus) {
        List<Integer> winnerNums = splitWinningNums(lastWeekWinningInput);

        ranks = new Ranks(lottoTickets, winnerNums, bonus);
        ofProfit(lottoTickets);
    }


    public static List<Integer> splitWinningNums(String lastWeekWinningInput) {
        String[] splitedWinningNums = lastWeekWinningInput.split(WINNING_NUM_DELIMITER);

        int numSize = splitedWinningNums.length;
        List<Integer> winningNums = new ArrayList<>();

        for (int i = 0; i < numSize; i++) {
            winningNums.add(Integer.parseInt(splitedWinningNums[i]));
        }

        return winningNums;
    }

    private Winner ofProfit(LottoTickets lottoTickets) {
        int lottoTicketsSize = lottoTickets.size();

        return new Winner(ranks, ranks.calculateProfit(lottoTicketsSize));
    }

    public Ranks getRanks() {
        return this.ranks;
    }

    public String toStringProfit() {
        return this.profit.toString();
    }
}
