package lotto;

import static lotto.LottoCommonUtil.convertMoneyFromString;

public enum Rank {
    FIRST(6, "2_000_000_000"),
    SECOND(5, "30_000_000"),
    THIRD(5, "1_500_000"),
    FOURTH(4, "50_000"),
    FIFTH(3, "5_000"),
    MISS(0, "0");

    private int countOfMatch;
    private String winningMoney;

    private Rank(int count, String winningMoney){
        this.countOfMatch = count;
        this.winningMoney = winningMoney;
    }

    public int calculateTotalPrize(int count) {
        int prize = convertMoneyFromString(this.winningMoney);
        return count * prize;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus){
    //일치하는 수를 로또 등수로 변경한다? enum 값 목록은 Rank[] ranks = values();
        for(Rank rank : Rank.values()){
            if(countOfMatch == rank.countOfMatch){
                return isSecond(rank, matchBonus);
            }
        }
        return MISS;
    }

    private static Rank isSecond(Rank rank, boolean matchBonus){
        if(rank.equals(SECOND) && matchBonus){
            return SECOND;
        }
        if(rank.equals(SECOND) && !matchBonus){
            return THIRD;
        }
        return rank;
    }
}
