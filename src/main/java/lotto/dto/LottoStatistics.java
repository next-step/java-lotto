package lotto.dto;

import lotto.domain.LottoPrize;

public class LottoStatistics {

    private LottoProfit lottoProfit;

    private int firstCnt;
    private int secondCnt;
    private int thirdCnt;
    private int forthCnt;
    private int fifthCnt;

    public LottoStatistics(LottoProfit lottoProfit) {
        this.lottoProfit = lottoProfit;
    }

    /**
     * 등수별 개수 체크
     *
     * @param prize 등수
     */
    public void incrementPrizeCnt(LottoPrize prize) {
        switch (prize) {
            case FIRST:
                firstCnt++;
                break;
            case SECOND:
                secondCnt++;
                break;
            case THIRD:
                thirdCnt++;
                break;
            case FORTH:
                forthCnt++;
                break;
            case FIFTH:
                fifthCnt++;
                break;
            default:
                break;
        }
    }

    public LottoProfit getLottoProfit() {
        return lottoProfit;
    }

    public int getFirstCnt() {
        return firstCnt;
    }

    public int getSecondCnt() {
        return secondCnt;
    }

    public int getThirdCnt() {
        return thirdCnt;
    }

    public int getForthCnt() {
        return forthCnt;
    }

    public int getFifthCnt() {
        return fifthCnt;
    }
}
