package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum PrizeInformation {

    FIFTH(MatchStatus.of(3, false), 5_000),
    FOURTH(MatchStatus.of(4, false), 50_000),
    THIRD(MatchStatus.of(5, false), 1_500_000),
    SECOND(MatchStatus.of(5, true), 30_000_000),
    FIRST(MatchStatus.of(6, false), 2_000_000_000);

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
//        matchStatus.notAllowedBallOtherNumber(BONUS_BALL_MATCH_COUNT);

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

    public boolean containsBonusball(){
        return matchStatus.isBonusball();
    }
}
