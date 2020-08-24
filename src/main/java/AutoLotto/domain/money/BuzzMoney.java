package AutoLotto.domain.money;

import java.util.List;

public enum BuzzMoney {
    Hit3(3, 5000),
    Hit4(4, 50000),
    Hit5(5, 1500000),
    Hit6(6, 2000000000);

    private final int numOfHits;
    private final int moneyPerHit;

    BuzzMoney(int numOfHits, int moneyPerHit) {
        this.numOfHits = numOfHits;
        this.moneyPerHit = moneyPerHit;
    }
/*
    public int createOnceBuzzMoney(BuzzMoney buzzMoney,int hit) {
        return hit * buzzMoney.moneyPerHit;
    }

    public int createSumBuzzMoney(BuzzMoney buzzMoney, List<Integer> hitsList) {
        int sum = hitsList
                .stream( )
                .filter(o -> o.equals(buzzMoney))
                .map(o -> createOnceBuzzMoney(buzzMoney, o)).findFirst( )
                .orElseThrow(IllegalArgumentException::new);
        return sum;
    }

    public int createSumBuzzMoney2(List<BuzzMoney> buzzMoneyList, List<Integer> hitsList) {
        buzzMoneyList.stream().filter(o -> o.)
    }

 */
}

