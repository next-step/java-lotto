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
    private double profitRate;


    protected LottoGame(int buyingPrice) {
        this.lottoLines = new ArrayList<>();
        this.gameCount = calculateGameCount(buyingPrice);
        buyLottoLines(gameCount);
    }

    protected LottoGame(int buyingPrice, int passiveGameCount, List<LottoLine> passiveLottoLines) {
        this.lottoLines = new ArrayList<>();
        this.gameCount = calculateGameCount(buyingPrice);
        
        validatePassiveGameCount(passiveGameCount);
        buyLottoLines(passiveLottoLines);
        buyLottoLines(gameCount - passiveGameCount);
    }

    private static int calculateGameCount(int buyingPrice) {
        return buyingPrice / LOTTO_PRICE;
    }

    public static LottoGame from(int buyingPrice) {
        return new LottoGame(buyingPrice);
    }

    public static LottoGame newInstance(int buyingPrice, int passiveGameCount, List<LottoLine> passiveLottoLines) {
        return new LottoGame(buyingPrice, passiveGameCount, passiveLottoLines);
    }

    private void validatePassiveGameCount(int passiveGameCount) {
        if (passiveGameCount > gameCount) {
            throw new IllegalArgumentException("수동 구매 수는 전체 수보다 클 수 없습니다.");
        }
    }

    public void calculateStatistics() {
        this.lottoStatistics = winningLottoLine.match(lottoLines, bonusBall);
        this.profitRate = lottoStatistics.getTotalProfit() / ((double) gameCount * LOTTO_PRICE);
    }

    public void registerWinningLottoLine(WinnginLottoLine winningLottoLine) {
        this.winningLottoLine = winningLottoLine;
    }

    private void buyLottoLines(int buyCount) {
        int index = 0;
        while (index < buyCount) {
            lottoLines.add(LottoLine.create());
            index++;
        }
    }

    private void buyLottoLines(List<LottoLine> passiveLottoLines) {
        lottoLines.addAll(passiveLottoLines);
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
        return profitRate;
    }

    public void registerBonusBall(int bonusBall) {
        this.bonusBall = LottoNumber.from(bonusBall);
    }
}
