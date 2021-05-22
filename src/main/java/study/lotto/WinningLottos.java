package study.lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WinningLottos {
    private Map<Integer, Integer> winningLottos;
    private BigDecimal winningPrizeAmount;

    public WinningLottos(Map<Integer, Integer> winningLottos) {
        this.winningLottos = winningLottos;
    }


    public WinningLottos() {
        Map<Integer, Integer> initializedWinningLottos = new HashMap<>();
        initializedWinningLottos.put(3,0);
        initializedWinningLottos.put(4,0);
        initializedWinningLottos.put(5,0);
        initializedWinningLottos.put(6,0);
        this.winningLottos = initializedWinningLottos;
        this.winningPrizeAmount = BigDecimal.ZERO;
    }

    public void add(int matchCount) {
        if (winningLottos.containsKey(matchCount)){
            winningLottos.put(matchCount, winningLottos.get(matchCount)+1);
            winningPrizeAmount = winningPrizeAmount.add(WinningPrize.prize(matchCount));
        }
    }

    public int prizeCount(int matchCount) {
        return winningLottos.get(matchCount);
    }

    public BigDecimal winningPrizeAmount(){
        return winningPrizeAmount;
    }

}
