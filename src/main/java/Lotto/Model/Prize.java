package Lotto.Model;

public enum Prize {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, true),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean checkBonus;

    Prize(int countOfMatch, int winningMoney, boolean checkBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.checkBonus = checkBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        Prize[] prizes = values();

        for(Prize prize : prizes){
            if(prize.getCheckBonus()){
                if(matchBonus){
                    return SECOND;
                }

                return THIRD;
            }

            if(prize.getCountOfMatch() == countOfMatch){
                return prize;
            }
        }


        return MISS;
    }
}
