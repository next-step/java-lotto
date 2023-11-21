package domain.lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoLine> lottoLines;
    private final LottoStatistics lottoStatistics;
    private final int gameCount;
    private LottoLine winningLottoLine;


    private LottoGame(int buyingPrice) {
        this.lottoStatistics = new LottoStatistics();
        this.lottoLines = new ArrayList<>();
        this.gameCount = calculateGameCount(buyingPrice);
        buyLottoLines();
    }

    public static LottoGame from(Integer buyingPrice) {
        return new LottoGame(buyingPrice);
    }

    private static int calculateGameCount(int buyingPrice) {
        return buyingPrice / LOTTO_PRICE;
    }

    public void calculateStatistics() {
        lottoLines.forEach(lottoLine -> {
            Set<LottoNumber> winningLottoNumbers = new HashSet<>(winningLottoLine.getLottoNumbers());
            winningLottoNumbers.retainAll(lottoLine.getLottoNumbers());
            int matchCount = winningLottoNumbers.size();
            this.lottoStatistics.calculate(matchCount);
        });
    }

    private void buyLottoLines() {
        int index = 0;
        while (index < gameCount) {
            lottoLines.add(LottoLine.create());
            index++;
        }
    }

    public void registerWinningLottoLine(LottoLine winningLottoLine) {
        this.winningLottoLine = winningLottoLine;
    }

    public List<LottoLine> getLottoLines() {
        return lottoLines;
    }

    public int getGameCount() {
        return gameCount;
    }

    public LottoLine getWinningLottoLine() {
        return winningLottoLine;
    }

    public LottoStatistics getLottoStatistics() {
        return lottoStatistics;
    }

    public double getProfitRate() {
        return lottoStatistics.getTotalProfit() / ((double) gameCount * LOTTO_PRICE);
    }
}
