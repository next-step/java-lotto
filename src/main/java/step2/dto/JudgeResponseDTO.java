package step2.dto;

import step2.domain.Price;

import java.util.HashMap;

public class JudgeResponseDTO {
    private final HashMap<Price, Integer> priceCountMap;
    private final double profitIndex;

    public JudgeResponseDTO(HashMap<Price, Integer> priceCountMap, double profit) {
        this.priceCountMap = priceCountMap;
        this.profitIndex = profit;
    }

    public int getFirstPriceCount() {
        return priceCountMap.get(Price.FIRST);
    }

    public int getSecondPriceCount() {
        return priceCountMap.get(Price.SECOND);
    }

    public int getThirdPriceCount() {
        return priceCountMap.get(Price.THIRD);
    }

    public int getForthPriceCount() {
        return priceCountMap.get(Price.FORTH);
    }

    public int getFifthPriceCount() {
        return priceCountMap.get(Price.FIFTH);
    }

    public double getProfitIndex() {
        return profitIndex;
    }
}
