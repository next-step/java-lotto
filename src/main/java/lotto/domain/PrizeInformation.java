package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum PrizeInformation {

    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    ALL_MATCH(6, 2_000_000_000);

    private static final Map<Integer, PrizeInformation> matchByPrice = new HashMap<>();
    static{
        for(PrizeInformation prize : PrizeInformation.values()){
            matchByPrice.put(prize.getMatchNumberCount(), prize);
        }
    }

    private final int matchNumberCount;
    private final int prizePrice;

    PrizeInformation(int matchNumberCount, int prizePrice){
        this.matchNumberCount = matchNumberCount;
        this.prizePrice = prizePrice;
    }

    public static PrizeInformation findByPrizePrice(int matchCount){
       return matchByPrice.get(matchCount);
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getPrizePrice(){
        return prizePrice;
    }
}
