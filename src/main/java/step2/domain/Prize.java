package step2.domain;

import java.util.Map;

public enum Prize {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchNumber;
    private final int prizeMoney;

    Prize(int matchNumber, int prizeMoney){
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumber(){
        return matchNumber;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

    public static int getPrize(int matchNumber){
        if(matchNumber==Prize.FIRST.matchNumber){
            return Prize.FIRST.getPrizeMoney();
        }
        if(matchNumber==Prize.SECOND.matchNumber){
            return Prize.SECOND.getPrizeMoney();
        }
        if(matchNumber==Prize.THIRD.matchNumber){
            return Prize.THIRD.getPrizeMoney();
        }
        if(matchNumber==Prize.FOURTH.matchNumber){
            return Prize.FOURTH.getPrizeMoney();
        }
        return 0;
    }

    public static int calculateSumOfPrizeMoney(Map<Integer, Integer> result){
        int sumOfPrizeMoney = 0;
        if(result.get(Prize.FOURTH.getMatchNumber())>0) {
            sumOfPrizeMoney += result.get(Prize.FOURTH.getMatchNumber()) * Prize.FOURTH.getPrizeMoney();
        }
        if(result.get(Prize.THIRD.getMatchNumber())>0) {
            sumOfPrizeMoney += result.get(Prize.THIRD.getMatchNumber()) * Prize.THIRD.getPrizeMoney();
        }
        if(result.get(Prize.SECOND.getMatchNumber())>0) {
            sumOfPrizeMoney += result.get(Prize.SECOND.getMatchNumber()) * Prize.SECOND.getPrizeMoney();
        }
        if(result.get(Prize.FIRST.getMatchNumber())>0) {
            sumOfPrizeMoney += result.get(Prize.FIRST.getMatchNumber()) * Prize.FIRST.getPrizeMoney();
        }
        return sumOfPrizeMoney;
    }

    public static double calculateEarningRatio(int sumOfPrizeMoney, int purchasingAmount){
        return (double) sumOfPrizeMoney/purchasingAmount;
    }
}
