package step2.domain;

import step2.utils.StringUtil;

import java.util.List;

public class PrizeMoney {
    public static final int LOWEST_RANK_FOR_PRIZE = 4;
    public static final int HIGHEST_RANK_FOR_PRIZE = 1;

    public static final int MATCH_COUNT_FOR_FOURTH_PLACE = 3;
    public static final int MATCH_COUNT_FOR_THIRD_PLACE = 4;
    public static final int MATCH_COUNT_FOR_SECOND_PLACE = 5;
    public static final int MATCH_COUNT_FOR_FIRST_PLACE = 6;

    public static final int PRIZE_MONEY_FOR_FOURTH_PLACE = 5000;
    public static final int PRIZE_MONEY_FOR_THIRD_PLACE = 50000;
    public static final int PRIZE_MONEY_FOR_SECOND_PLACE = 1500000;
    public static final int PRIZE_MONEY_FOR_FIRST_PLACE = 2000000000;

    private int amountOfPrizeMoney;

    public PrizeMoney(){
        amountOfPrizeMoney = 0;
    }

    public int getPrizeMoneyAsMatchCount(int matchCount){
        if(matchCount== MATCH_COUNT_FOR_FOURTH_PLACE){
            amountOfPrizeMoney +=PRIZE_MONEY_FOR_FOURTH_PLACE;
            return PRIZE_MONEY_FOR_FOURTH_PLACE;
        }
        if(matchCount== MATCH_COUNT_FOR_THIRD_PLACE){
            amountOfPrizeMoney +=PRIZE_MONEY_FOR_THIRD_PLACE;
            return PRIZE_MONEY_FOR_THIRD_PLACE;
        }
        if(matchCount== MATCH_COUNT_FOR_SECOND_PLACE){
            amountOfPrizeMoney +=PRIZE_MONEY_FOR_SECOND_PLACE;
            return PRIZE_MONEY_FOR_SECOND_PLACE;
        }
        if(matchCount== MATCH_COUNT_FOR_FIRST_PLACE){
            amountOfPrizeMoney +=PRIZE_MONEY_FOR_FIRST_PLACE;
            return PRIZE_MONEY_FOR_FIRST_PLACE;
        }
        return 0;
    }

    public static int getMatchCountForPrize(int rank){
        if(rank==4){
            return MATCH_COUNT_FOR_FOURTH_PLACE;
        }
        if(rank==3){
            return MATCH_COUNT_FOR_THIRD_PLACE;
        }
        if(rank==2){
            return MATCH_COUNT_FOR_SECOND_PLACE;
        }
        if(rank==1){
            return MATCH_COUNT_FOR_FIRST_PLACE;
        }
        return 0;
    }

    public int getAmountOfPrizeMoney(){
        return amountOfPrizeMoney;
    }
}
