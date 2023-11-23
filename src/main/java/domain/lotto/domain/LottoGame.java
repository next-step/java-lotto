package domain.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoLine> lottoLines;
    private final int gameCount;
    private LottoStatistics lottoStatistics;
    private WinnginLottoLine winningLottoLine;
    private LottoNumber bonusBall;


    protected LottoGame(int buyingPrice) {
        this.lottoLines = new ArrayList<>();
        this.gameCount = calculateGameCount(buyingPrice);
        buyLottoLines();
    }

    private static int calculateGameCount(int buyingPrice) {
        return buyingPrice / LOTTO_PRICE;
    }

    public static LottoGame from(Integer buyingPrice) {
        return new LottoGame(buyingPrice);
    }


    public void calculateStatistics() {
        this.lottoStatistics = winningLottoLine.match(lottoLines, bonusBall);
    }

    public void registerWinningLottoLine(WinnginLottoLine winningLottoLine) {
        this.winningLottoLine = winningLottoLine;
    }

    private void buyLottoLines() {
        int index = 0;
        while (index < gameCount) {
            lottoLines.add(LottoLine.create());
            index++;
        }
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

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public double getProfitRate() {
        return lottoStatistics.getTotalProfit() / ((double) gameCount * LOTTO_PRICE);
    }

    public void registerBonusBall(int bonusBall) {
        this.bonusBall = LottoNumber.from(bonusBall);
    }
}
