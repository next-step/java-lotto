package step4.model;

import step4.enumeration.LottoRank;

import java.util.Map;

public class LottoWinner {

    private final Map<LottoRank, Integer> winnerBoard;

    public LottoWinner(Map<LottoRank, Integer> winnerBoard) {
        this.winnerBoard = winnerBoard;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<LottoRank, Integer> board : this.winnerBoard.entrySet()) {
            if (board.getValue() > 0) totalPrice += LottoRank.getPriceByName(board.getKey());
        }

        return totalPrice;
    }

    public Double getRating(int payPrice) {
        int totalPrice = getTotalPrice();
        return Math.floor(totalPrice * 100.0 / payPrice) / 100;
    }
}
