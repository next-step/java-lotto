package lottosecond.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinnerBoard {

    private Map<Integer, Long> winnerBoard;
    private Map<Integer, Integer> priceBoard;

    public WinnerBoard(Map<Integer, Long> winnerBoard) {
        this.winnerBoard = winnerBoard;

        this.priceBoard = new HashMap<>();
        this.priceBoard.put(3, 5000);
        this.priceBoard.put(4, 50000);
        this.priceBoard.put(5, 1500000);
        this.priceBoard.put(6, 2000000000);
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Integer key : priceBoard.keySet()) {
            totalPrice += priceBoard.get(key) * winnerBoard.get(key);
        }
        return totalPrice;
    }

    public long getWinningLottoCount(int key) {
        return winnerBoard.get(key);
    }

    public int getWinningLottoPrice(int key) {
        return priceBoard.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerBoard that = (WinnerBoard) o;
        return Objects.equals(winnerBoard, that.winnerBoard) && Objects.equals(priceBoard, that.priceBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerBoard, priceBoard);
    }
}
