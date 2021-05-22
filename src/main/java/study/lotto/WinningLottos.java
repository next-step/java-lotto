package study.lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningLottos {
    private Map<Integer, Integer> winningLottos;

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
    }

    public void add(int checkPrize) {
        if (winningLottos.containsKey(checkPrize)){
            winningLottos.put(checkPrize, winningLottos.get(checkPrize)+1);
        }
    }

    public int prizeCount(int matchCount) {
        return winningLottos.get(matchCount);
    }

}
