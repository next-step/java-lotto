package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum PrizeInformation {

    THREE_MATCH(new PrizeStatus(3), 5000),
    FOUR_MATCH(new PrizeStatus(4), 50000),
    FIVE_MATCH(new PrizeStatus(5), 1500000),
    ALL_MATCH(new PrizeStatus(6), 2000000000);

    private static final Map<PrizeStatus, PrizeInformation> matchByPrice = new HashMap<>();
    static{
        for(PrizeInformation prize : PrizeInformation.values()){
            matchByPrice.put(prize.getPrizeStatus(), prize);
        }
    }

    private final PrizeStatus prizeStatus;
    private final int prizePrice;

    PrizeInformation(PrizeStatus prizeStatus, int prizePrice){
        this.prizeStatus = prizeStatus;
        this.prizePrice = prizePrice;
    }

    public static PrizeInformation findByPrizePrice(int matchCount){
       return matchByPrice.get(new PrizeStatus(matchCount));
    }

    public PrizeStatus getPrizeStatus() {
        return prizeStatus;
    }

    public int getPrizePrice(){
        return prizePrice;
    }
}
