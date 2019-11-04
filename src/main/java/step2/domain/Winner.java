package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";
    private static final int MATCH_THREE_NUMBER = 3;
    private static final int MATCH_FOUR_NUMBER = 4;
    private static final int MATCH_FIVE_NUMBER = 5;
    private static final int MATCH_SIX_NUMBER = 6;
    private static final int MATCH_THREE_JACKPOT = 5000;
    private static final int MATCH_FOUR_JACKPOT = 50000;
    private static final int MATCH_FIVE_JACKPOT = 1500000;
    private static final int MATCH_SIX_JACKPOT = 2000000000;
    public static final int LOTTO_PRICE = 1000;

    private List<Integer> winnerNums;
    private Map<Integer, Integer> countOfRanks = new HashMap<>();
    private Long profit;


    public Winner(List<LottoTicket> lottoTickets, String lastWeekWinningInput) {
        getWinner(lottoTickets, lastWeekWinningInput);

        int lottoTicketsSize = lottoTickets.size();
        calculateProfit(lottoTicketsSize);
    }

    public Winner getWinner(List<LottoTicket> lottoTickets, String lastWeekWinningInput) {
        winnerNums = splitWinningNums(lastWeekWinningInput);

        for(LottoTicket lottoTicket : lottoTickets) {
            List<Integer> candidateNums = lottoTicket.getLottoNums();

            int matchCount = matchNumber(candidateNums, winnerNums);
            countWinning(matchCount);
        }
        return this;
    }

    public int matchNumber(List<Integer> candidateNums, List<Integer> winnerNums) {
        Long matchNumer = candidateNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(matchNumer);
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

    private void countWinning(int matchCount) {
        countOfRanks.put(matchCount, countOfRanks.getOrDefault(matchCount, 0) + 1);
    }

    private void calculateProfit(int lottoTicketsSize) {
        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : countOfRanks.entrySet()) {
            if(entry.getKey() == MATCH_THREE_NUMBER) {
                sum += MATCH_THREE_JACKPOT * entry.getValue();
            }

            if(entry.getKey() == MATCH_FOUR_NUMBER) {
                sum += MATCH_FOUR_JACKPOT * entry.getValue();
            }

            if(entry.getKey() == MATCH_FIVE_NUMBER) {
                sum += MATCH_FIVE_JACKPOT * entry.getValue();
            }

            if(entry.getKey() == MATCH_SIX_NUMBER) {
                sum += MATCH_SIX_JACKPOT * entry.getValue();
            }
        }

        int purchaseAmount = lottoTicketsSize * LOTTO_PRICE;
        this.profit = Math.round((sum/(double)purchaseAmount*100)/100);
    }


    public Long getProfit() {
        return this.profit;
    }

    public Map<Integer, Integer> getCountOfRanks() {
        return this.countOfRanks;
    }
}
