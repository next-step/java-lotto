package step4.model;

import step4.enumeration.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoWinner {

    private final List<Lotto> lottos;
    private final LottoWinNumbers lottoWinNumbers;

    public LottoWinner(List<Lotto> lottos, LottoWinNumbers lottoWinNumbers) {
        this.lottos = lottos;
        this.lottoWinNumbers = lottoWinNumbers;
    }

    public int getTotalPrice(Map<LottoRank, Integer> winnerBoard) {
        int totalPrice = 0;
        for (Map.Entry<LottoRank, Integer> board : winnerBoard.entrySet()) {
            if (board.getValue() > 0) totalPrice += LottoRank.getPriceByName(board.getKey());
        }

        return totalPrice;
    }

    public Map<LottoRank, Integer> getWinnerNumberMatchCount(int bonusNumber) {
        Map<LottoRank, Integer> winnerBoard = LottoRank.rankMap();
        for (Lotto lotto : this.lottos) {
            LottoRank rankName = lotto.getLottoRank(this.lottoWinNumbers.getWinNumbers(), bonusNumber);
            winnerBoard.put(rankName, winnerBoard.get(rankName) + 1);
        }

        return winnerBoard;
    }

    public Double getRating(int payPrice, Map<LottoRank, Integer> winnerBoard) {
        int totalPrice = getTotalPrice(winnerBoard);
        return Math.floor(totalPrice * 100.0 / payPrice) / 100;
    }
}
