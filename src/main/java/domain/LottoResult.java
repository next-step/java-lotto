package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Rank, Integer> result = new HashMap<>();

    public LottoResult(List<Rank> ranks) {
        initResult();
        setResults(ranks);
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    private void setResults(List<Rank> ranks) {
        for (Rank rank : ranks) {
            result.put(rank, plus(rank));
        }
    }

    private int plus(Rank rank) {
        return matchCount(rank) + 1;
    }

    public int matchCount(Rank selectedRank) {
        return result.get(selectedRank);
    }

    public List<Rank> getRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.MISS))
                .collect(Collectors.toList());
    }
    
    private int sizeOfTicket() {
        int ticketSize = 0;
        for (Rank rank : Rank.values()) {
            ticketSize += result.get(rank);
        }
        return ticketSize;
    }

    public double calculatorRate() {
        int totalPrizeMoney = getTotalPrizeMoney();
        double rate = (double)totalPrizeMoney / getPaidLotto();
        return new BigDecimal(rate)
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();
    }

    private int getPaidLotto() {
        return Lotto.PRICE * sizeOfTicket();
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeMoney += rank.getTotalPrizeMoney(matchCount(rank));
        }
        return totalPrizeMoney;
    }
}
