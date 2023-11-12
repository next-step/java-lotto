package lottoauto.domain.aggregate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinnerBoard {

    private final Map<Integer, Integer> winnerBoard;

    public WinnerBoard() {
        winnerBoard = new HashMap<>();
        winnerBoard.put(3, 0);
        winnerBoard.put(4, 0);
        winnerBoard.put(5, 0);
        winnerBoard.put(6, 0);
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
