package Lotto.Model;

public enum Prize {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Prize(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Prize valueOf(int countOfMatch, boolean matchBonus) {
        if(countOfMatch == 3){
            return FIFTH;
        }

        if(countOfMatch == 4){
            return FOURTH;
        }

        if(countOfMatch == 5 && !matchBonus){
            return THIRD;
        }

        if(countOfMatch == 5){
            return SECOND;
        }

        if(countOfMatch == 6){
            return FIRST;
        }

        return MISS;
    }

    public String getString() {
        if(winningMoney == 30_000_000){
            return countOfMatch + "개 일치, 보너스 볼 일치 (" + winningMoney + "원) - ";
        }

        return countOfMatch + "개 일치 (" + winningMoney + "원) - ";
    }
}
