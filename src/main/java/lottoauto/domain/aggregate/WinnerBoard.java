package lottoauto.domain.aggregate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinnerBoard {

    private Map<Integer, Integer> winnerBoard;
    private Map<Integer, Integer> priceBoard;

    public WinnerBoard() {
        winnerBoard = new HashMap<>();
        winnerBoard.put(3, 0);
        winnerBoard.put(4, 0);
        winnerBoard.put(5, 0);
        winnerBoard.put(6, 0);

        priceBoard = new HashMap<>();
        priceBoard.put(3, 5000);
        priceBoard.put(4, 50000);
        priceBoard.put(5, 1500000);
        priceBoard.put(6, 2000000000);
    }

    public WinnerBoard(Map<Integer, Integer> winnerBoard) {
        this.winnerBoard = winnerBoard;
    }

    public void put(int winNumber) {
        if (winnerBoard.containsKey(winNumber)) {
            winnerBoard.put(winNumber, winnerBoard.get(winNumber) + 1);
        }
    }

    public int get(Integer key) {
        return winnerBoard.get(key);
    }

    public Map<Integer, Integer> getWinnerBoard() {
        return winnerBoard;
    }

    public Map<Integer, Integer> getPriceBoard() {
        return priceBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerBoard that = (WinnerBoard) o;
        return Objects.equals(winnerBoard, that.winnerBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerBoard);
    }
}
