import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<Integer, Integer> winningMap;

    public double getAdvantageRate() {
        return 0.0;
    }

    public int getFirst() {
        return winningMap.get(6);
    }

    public int getSecond() {
        return winningMap.get(5);
    }

    public int getThird() {
        return winningMap.get(4);
    }

    public int getFourth() {
        return winningMap.get(3);
    }

    public Map<Integer, Integer> getWinningMap() {
        return winningMap;
    }

    public WinningStatistics() {
        winningMap = new HashMap<>();
        winningMap.put(0, 0);
        winningMap.put(1, 0);
        winningMap.put(2, 0);
        winningMap.put(3, 0);
        winningMap.put(4, 0);
        winningMap.put(5, 0);
        winningMap.put(6, 0);
    }
}
