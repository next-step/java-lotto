package lotto.domain;

import java.util.Map;

public class LottoWinStatistics {

    private static final float MATCH_THREE_PRIZE = 5_000;
    private static final float MATCH_FOUR_PRIZE = 50_000;
    private static final float MATCH_FIVE_PRIZE = 1_500_000;
    private static final float MATCH_SIX_PRIZE = 2_000_000_000;

    private final Map<Integer, Integer> lottoWinStatistics;
    private final Float rateOfReturn;

    public LottoWinStatistics(LottoBuy lottoBuy, LottoWinNumber lottoWinNumber) {
        this.lottoWinStatistics = lottoBuy.calculateLottoWinStatistics(lottoWinNumber);
        this.rateOfReturn = getRateOfReturn(lottoBuy.getLottoBuyPrice());
    }

    private String getThreeMatches() {
        return "3개 일치 (5000원)- " + lottoWinStatistics.getOrDefault(3, 0) + "개\n";
    }

    private String getFourMatches() {
        return "4개 일치 (50000원)- " + lottoWinStatistics.getOrDefault(4, 0) + "개\n";
    }

    private String getFiveMatches() {
        return "5개 일치 (1500000원)- " + lottoWinStatistics.getOrDefault(5, 0) + "개\n";
    }

    private String getSixMatches() {
        return "6개 일치 (2000000000원)- " + lottoWinStatistics.getOrDefault(6, 0)+ "개\n";
    }

    private String getConclusion() {
        double roundedRateOfReturn = Math.floor(rateOfReturn * 100) / 100;
        String result = String.format("총 수익률은 %.2f입니다.", roundedRateOfReturn);

        if (rateOfReturn < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        return result;
    }

    private Float getRateOfReturn(int lottoBuyPrice) {
        int threeMatchCount = lottoWinStatistics.getOrDefault(3, 0);
        int fourMatchCount = lottoWinStatistics.getOrDefault(4, 0);
        int fiveMatchCount = lottoWinStatistics.getOrDefault(5, 0);
        int sixMatchCount = lottoWinStatistics.getOrDefault(6, 0);


        return (MATCH_THREE_PRIZE * threeMatchCount
                + MATCH_FOUR_PRIZE * fourMatchCount
                + MATCH_FIVE_PRIZE * fiveMatchCount
                + MATCH_SIX_PRIZE * sixMatchCount)
                / lottoBuyPrice;
    }
    
    @Override
    public String toString() {
        return getThreeMatches()
                + getFourMatches()
                + getFiveMatches()
                + getSixMatches()
                + getConclusion();
    }
}
