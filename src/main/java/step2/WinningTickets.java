package step2;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningTickets {

    private Map<Rank, Integer> winningTickets = new LinkedHashMap<>();

    public WinningTickets() {
        for(int i = 3; i <= 6; i ++){
            winningTickets.put(Rank.of(i), 0);
        }
    }

    public void addWinner(Rank rank) {
        if(winningTickets.containsKey(rank)){
            winningTickets.put(rank, winningTickets.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getWinningTickets() {
        return winningTickets;
    }

    public double revenue(int payedPrice){
        double winningPrice = 0;
        for (Rank rank : winningTickets.keySet()) {
            if(winningTickets.get(rank) >= 1) {
                winningPrice += rank.getReward() * winningTickets.get(rank);
            }
        }
        return winningPrice / payedPrice;
    }



    public String isBenefit(double revenue) {
        if(revenue > 1) {
            return "이득";
        }
        if(revenue < 1) {
            return "손해";
        }
        return "동률";
    }
}
