package lotto.core;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.core.TicketPriceInput.DEFAULT_TICKET_PRICE;

public class WinnerCount {

    private final Map<WinnerRank, Integer> winnerCount = new EnumMap<>(WinnerRank.class);

    private final static int DEFAULT_OFFSET = 1;

    public WinnerCount() {
        winnerCount.put(WinnerRank.FIRST, 0);
        winnerCount.put(WinnerRank.SECOND, 0);
        winnerCount.put(WinnerRank.THIRD, 0);
        winnerCount.put(WinnerRank.FORTH, 0);
    }

    public void plusCount(WinnerRank winnerRank){
        winnerCount.put(winnerRank, winnerCount.get(winnerRank) + DEFAULT_OFFSET);
    }

    public int getAllProfit(){
        int result = 0;
        for(Map.Entry<WinnerRank, Integer> entry : winnerCount.entrySet()){
            result += entry.getKey().getAward() * entry.getValue();
        }
        return result;
    }

    public double getProfitRatio(Lottos lottos){
        return getAllProfit() / (double) (lottos.getLottosAmount() * DEFAULT_TICKET_PRICE);
    }

    public Map<WinnerRank, Integer> getWinnerCount() {
        return winnerCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerCount that = (WinnerCount) o;
        return Objects.equals(winnerCount, that.winnerCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCount);
    }
}
