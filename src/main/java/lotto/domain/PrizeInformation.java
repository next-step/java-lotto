package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum PrizeInformation {

    FIRST(new MatchStatus(6, false), 2_000_000_000),
    SECOND(new MatchStatus(5, true), 30_000_000),
    THIRD(new MatchStatus(5, false), 1_500_000),
    FOURTH(new MatchStatus(4, false), 50_000),
    FIFTH(new MatchStatus(3, false), 5_000);

    private static final int BONUS_BALL_MATCH_COUNT = 5;
    private static final Map<MatchStatus, PrizeInformation> matchByPrice = new HashMap<>();
    static{
        for(PrizeInformation prize : PrizeInformation.values()){
            matchByPrice.put(prize.getMatchStatus(), prize);
        }
    }

    private final MatchStatus matchStatus;
    private final int prizePrice;

    PrizeInformation(MatchStatus matchStatus, int prizePrice){
        this.matchStatus = matchStatus;
        this.prizePrice = prizePrice;
    }

    public static PrizeInformation findByPrizePrice(MatchStatus matchStatus){
        if(matchStatus.getMatchCount() != BONUS_BALL_MATCH_COUNT){
            matchStatus.isNotBonusballMatchRule();
        }
        return matchByPrice.get(matchStatus);
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public int countMatchNumber(){
        return matchStatus.getMatchCount();
    }

    public int getPrizePrice(){
        return prizePrice;
    }
}
