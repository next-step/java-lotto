package step2.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private int totalWinningPrice;

    public WinningStatistics(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getTotalWinningPrice() {
        return lottoList.stream()
                .mapToInt(Lotto::getPrice)
                .sum();
    }


    public float getWinningStatic() {
        totalWinningPrice = getTotalWinningPrice();
        if(lottoList.size() == 0) {
            return 0;
        }
        return (float) totalWinningPrice / (MakeLottoFactory.LOTTO_PRICE * lottoList.size());
    }

    public boolean isBenefit() {
        if(getWinningStatic() > (float) 1) {
            return true;
        }
        return false;
    }

    public String getBenefitOrNot() {
        if(isBenefit()) {
            return "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

}
