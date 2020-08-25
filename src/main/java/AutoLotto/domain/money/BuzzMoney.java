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

    public static int createOnceBuzzMoney(BuzzMoney buzzMoney, int hit) {
        return hit * buzzMoney.moneyPerHit;
    }

    public static int createBuzzMoney(BuzzMoney buzzMoney, List<Integer> hitsList) {
        int sum = 0;
        for (int i = 0; i <hitsList.size(); i++) {
            if (buzzMoney.numOfHits == hitsList.get(i)) {
                sum += createOnceBuzzMoney(buzzMoney, hitsList.get(i));
            }
            return sum;
        }
        return sum;
    }

    public static int createAllMoney(List<BuzzMoney> buzzMoneyList, List<Integer> hitsList) {
        int sum = 0;
        for (int i = 0; i < buzzMoneyList.size( ); i++) {
            sum += createBuzzMoney(buzzMoneyList.get(i), hitsList);
        }
        return sum;
    }
    
//        int sum = buzzMoneyList
//                .stream( )
//                .filter(o -> o.of(buzzMoney))
//                .map(o -> createBuzzMoney(o, hitList))
//                .forEach(o -> buzzMoneyList.add(o));
//       return sum;
/*
    public int createBuzzMoney2(BuzzMoney buzzMoney, List<Integer> hitsList) {
        int sum = hitsList
                .stream( )
                .filter(o -> o.equals(buzzMoney))
                .map(o -> createOnceBuzzMoney(buzzMoney, o)).findFirst( )
                .orElseThrow(IllegalArgumentException::new);
        return sum;
    }
 */
}

