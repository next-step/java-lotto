package step2;

import java.util.Map;

public class PrizeMoney {
    public static final int MATCH_NUMBERS_NEED_TO_FIRST_GRADE  = 6;
    public static final int MATCH_NUMBERS_NEED_TO_SECOND_GRADE = 5;
    public static final int MATCH_NUMBERS_NEED_TO_THIRD_GRADE  = 4;
    public static final int MATCH_NUMBERS_NEED_TO_FOURTH_GRADE = 3;

    public static final int PRIZE_MONEY_FOR_FIRST_GRADE        = 2_000_000_000;
    public static final int PRIZE_MONEY_FOR_SECOND_GRADE       = 1_500_000;
    public static final int PRIZE_MONEY_FOR_THIRD_GRADE        = 50_000;
    public static final int PRIZE_MONEY_FOR_FOURTH_GRADE       = 5_000;

    private int sumOfPrizeMoney = 0;

    public void calculateSumOfPrizeMoney(Map<Integer, Integer> result){
        if(result.get(MATCH_NUMBERS_NEED_TO_FOURTH_GRADE)>0){
            sumOfPrizeMoney += result.get(MATCH_NUMBERS_NEED_TO_FOURTH_GRADE)*PRIZE_MONEY_FOR_FOURTH_GRADE;
        }
        if(result.get(MATCH_NUMBERS_NEED_TO_THIRD_GRADE)>0){
            sumOfPrizeMoney += result.get(MATCH_NUMBERS_NEED_TO_THIRD_GRADE)*PRIZE_MONEY_FOR_THIRD_GRADE;
        }
        if(result.get(MATCH_NUMBERS_NEED_TO_SECOND_GRADE)>0){
            sumOfPrizeMoney += result.get(MATCH_NUMBERS_NEED_TO_SECOND_GRADE)*PRIZE_MONEY_FOR_SECOND_GRADE;
        }
        if(result.get(MATCH_NUMBERS_NEED_TO_FIRST_GRADE)>0){
            sumOfPrizeMoney += result.get(MATCH_NUMBERS_NEED_TO_FIRST_GRADE)*PRIZE_MONEY_FOR_FIRST_GRADE;
        }
    }

    public int getSumOfPrizeMoney(){
        return sumOfPrizeMoney;
    }
}
