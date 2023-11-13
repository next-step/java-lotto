package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;

import java.util.List;
import java.util.Objects;

public class Aggregator {

    private final WinnerBoard winnerBoard;
    private final List<Lotto> lottoList;

    private static final int EACH_LOTTO_PRICE = 1000;

    public Aggregator(List<Lotto> lottoList) {
        winnerBoard = new WinnerBoard();
        this.lottoList = lottoList;
    }

    public WinnerBoard checkWinnerLotto(List<Integer> winNumbers) {
        for (Lotto lotto : lottoList) {
            int winNumber = lotto.getLottoScore(winNumbers);
            winnerBoard.updateWinningLottoCount(winNumber);
        }
        return winnerBoard;
    }

    public double calculateEarningRate() {
        int totalPrice = winnerBoard.calculateTotalPrice();
        return Math.floor(totalPrice * 100.0 / (lottoList.size() * EACH_LOTTO_PRICE)) / 100;
    }

    public WinnerBoard getWinnerBoard() {
        return winnerBoard;
    }

    public int totalLottoCount() {
        return lottoList.size();
    }

    public String lottoListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aggregator that = (Aggregator) o;
        return Objects.equals(getWinnerBoard(), that.getWinnerBoard()) && Objects.equals(lottoList, that.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinnerBoard(), lottoList);
    }
}
