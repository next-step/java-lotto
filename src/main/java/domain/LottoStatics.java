package domain;

import java.util.List;

import static domain.Rank.FIFTH;
import static domain.Rank.FIRST;
import static domain.Rank.FOURTH;
import static domain.Rank.SECOND;
import static domain.Rank.THIRD;

public class LottoStatics {
    private int fifthCount = 0;
    private int fourthCount = 0;
    private int thirdCount = 0;
    private int secondCount = 0;
    private int firstCount = 0;
    private int totalLottoCount = 0;
    private double profitRate;

    public static final int PROFIT_STANDARD = 1;

    public LottoStatics(List<Lotto> lottoList) {
        this.totalLottoCount = lottoList.size();
        this.makeStatics(lottoList);
        this.makeProfitRate();
    }

    private void makeStatics(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            this.increaseHitCount(lotto);
        }
    }


    private void increaseHitCount(Lotto lotto) {
        switch (lotto.getRank()) {
            case FIFTH:
                fifthCount++;
                break;
            case FOURTH:
                fourthCount++;
                break;
            case THIRD:
                thirdCount++;
                break;
            case SECOND:
                secondCount++;
                break;
            case FIRST:
                firstCount++;
                break;
        }
    }

    private void makeProfitRate() {
        int totalPrize = (fifthCount * FIFTH.getWinningMoney())
            + (fourthCount * FOURTH.getWinningMoney())
            + (thirdCount * THIRD.getWinningMoney())
            + (secondCount * SECOND.getWinningMoney())
            + (firstCount * FIRST.getWinningMoney());

        int totalSpent = totalLottoCount * Lotto.PRICE_PER_ONE;
        this.profitRate = (double) totalPrize / totalSpent;
    }

    public String getProfitRate() {
        double truncatedRate = Math.floor(this.profitRate * 100) / 100.0;
        return String.format("%.2f", truncatedRate);
    }

    public boolean isProfit() {
        return this.profitRate > PROFIT_STANDARD;
    }

    public int getFirstCount() {
        return this.firstCount;
    }

    public int getSecondCount() {
        return this.secondCount;
    }


    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }
}
