package lotto.domain;

import java.util.Map;

public class LottoWinStatics {

    private final Map<Integer, Integer> lottoWinStatics;
    private final Float rateOfReturn;

    public LottoWinStatics(LottoBuy lottoBuy, LottoWinNumber lottoWinNumber) {
        this.lottoWinStatics = lottoBuy.calculateLottoWinStatistics(lottoWinNumber);
        this.rateOfReturn = getRateOfReturn(lottoBuy.getLottoBuyPrice());
    }

    private String getThreeMatches() {
        return "3개 일치 (5000원)- " + lottoWinStatics.getOrDefault(3, 0) + "개\n";
    }

    private String getFourMatches() {
        return "4개 일치 (50000원)- " + lottoWinStatics.getOrDefault(4, 0) + "개\n";
    }

    private String getFiveMatches() {
        return "5개 일치 (1500000원)- " + lottoWinStatics.getOrDefault(5, 0) + "개\n";
    }

    private String getSixMatches() {
        return "6개 일치 (2000000000원)- " + lottoWinStatics.getOrDefault(6, 0)+ "개\n";
    }

    private String getResults() {
        double roundedRateOfReturn = Math.floor(rateOfReturn * 100) / 100;
        String result = String.format("총 수익률은 %.2f입니다.", roundedRateOfReturn);

        if (rateOfReturn < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        return result;
    }

    private Float getRateOfReturn(int lottoBuyPrice) {
        return (5000f * lottoWinStatics.getOrDefault(3, 0)
                + 50000 * lottoWinStatics.getOrDefault(4, 0)
                + 1500000 * lottoWinStatics.getOrDefault(5, 0)
                + 2000000000 * lottoWinStatics.getOrDefault(6, 0)) / lottoBuyPrice;
    }
    
    @Override
    public String toString() {
        return getThreeMatches()
                + getFourMatches()
                + getFiveMatches()
                + getSixMatches()
                + getResults();
    }
}
