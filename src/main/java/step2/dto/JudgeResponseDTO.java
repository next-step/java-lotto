package step2.dto;

import java.util.Map;

public class JudgeResponseDTO {
    private final Map<String, Integer> priceMap;
    private final Map<String, Integer> priceCountMap;
    private final double profitIndex;

    public JudgeResponseDTO(Map<String, Integer> priceMap, Map<String, Integer> priceCountMap, double profit) {
        this.priceMap = priceMap;
        this.priceCountMap = priceCountMap;
        this.profitIndex = profit;
    }

    public int getFirstPrice() {
        return priceMap.get("FIRST");
    }

    public int getFirstPriceCount() {
        return priceCountMap.get("FIRST");
    }

    public int getSecondPrice() {
        return priceMap.get("SECOND");
    }

    public int getSecondPriceCount() {
        return priceCountMap.get("SECOND");
    }

    public int getThirdPrice() {
        return priceMap.get("THIRD");
    }

    public int getThirdPriceCount() {
        return priceCountMap.get("THIRD");
    }

    public int getForthPrice() {
        return priceMap.get("FORTH");
    }

    public int getForthPriceCount() {
        return priceCountMap.get("FORTH");
    }

    public int getFifthPrice() {
        return priceMap.get("FIFTH");
    }

    public int getFifthPriceCount() {
        return priceCountMap.get("FIFTH");
    }

    public double getProfitIndex() {
        return profitIndex;
    }
}
