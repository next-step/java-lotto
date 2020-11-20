package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;

/**
 * 로또 상태
 */
public class LottoStatus {

    private static final int PRICE_1ST = 2000000000;
    private static final int PRICE_2ST = 1500000;
    private static final int PRICE_3ST = 50000;
    private static final int PRICE_4ST = 5000;

    private int winningCount = 0; // 맞은 갯수
    private int cumulativeAmount = 0; // 누적금액
    private int plusPrice = 0; // 당첨금액
    private int sameCount = 0;

    public LottoStatus(int lottoRank) {
        lottoWinningRankCheck(lottoRank);
        setDefaultData(lottoRank);
    }

    public void addLottoWinning() {
        cumulativeAmount = cumulativeAmount + plusPrice;
        winningCount++;
    }

    private void setDefaultData(int paramValue) {
        if (paramValue == 4) {
            plusPrice = PRICE_4ST;
            sameCount = 3;
            return;
        }
        if (paramValue == 3) {
            plusPrice = PRICE_3ST;
            sameCount = 4;
            return;
        }
        if (paramValue == 2) {
            plusPrice = PRICE_2ST;
            sameCount = 5;
            return;
        }
        if (paramValue == 1) {
            plusPrice = PRICE_1ST;
            sameCount = 6;
            return;
        }
    }

    private void lottoWinningRankCheck(int rank) {
        if (rank < 1 || rank > 4) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2RankException());
        }
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getCumulativeAmount() {
        return cumulativeAmount;
    }

    public int getPlusPrice() {
        return plusPrice;
    }
}
