package secondplacelotto.model;

public enum ProfitMatcher {

    TREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_AND_BONUS_MATCH(30000000),
    SIX_MATCH(2000000000);

    private final int money;

    ProfitMatcher(int money){
        this.money = money;
    }

    public static int getMatchProfit(int matchProfitIndex, int matchingCount) {
        return values()[matchProfitIndex].money * matchingCount;
    }
}
