package autolotto.model;

public enum ProfitMatcher {

    TREE_MATCH(3,5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    SIX_MATCH(6,2000000000);

    private final int matchNumber;
    private final int money;
    private static int result = 0;

    ProfitMatcher(int matchNumber, int money){
        this.matchNumber = matchNumber;
        this.money = money;
    }

    public static int getMatchProfit(int matchingNumber, int matchingCount){

        for(ProfitMatcher profitMatcher : values()){
            getMatchMoney(profitMatcher, matchingNumber);
        }

        return result * matchingCount;
    }

    private static void getMatchMoney(ProfitMatcher profitMatcher, int matchingNumber){
        if(profitMatcher.matchNumber == matchingNumber){
            result = profitMatcher.money;
        }
    }




}
