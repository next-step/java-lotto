package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private int totalWinningPrice;
    private Map winningMap;

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

    //    3개 일치 (5000원)- 1개
    //4개 일치 (50000원)- 0개
    //5개 일치 (1500000원)- 0개
    //6개 일치 (2000000000원)- 0개
    public Map<WinningPrice, Integer> makeWinningMap() {
        initWinnimgMap();
        for(Lotto lotto : lottoList) {
            winningMap.put(WinningPrice.valueOf(lotto.getWinningCount()),(int)winningMap.get(WinningPrice.valueOf(lotto.getWinningCount())) +1);
        }
        return winningMap;
    }

    public void initWinnimgMap() {
        winningMap = new EnumMap(WinningPrice.class);
        for(WinningPrice winningPrice:WinningPrice.values()) {
            winningMap.put(winningPrice,0);
        }
    }


}
