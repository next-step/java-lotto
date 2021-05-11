package lotto;

public enum LottoGame {
    MISS_MATCH(0,0),
    MATCH_3(3,5000 ),
    MATCH_4(4,50000),
    MATCH_5(5,1500000),
    MATCH_5_BONUS(5,30000000),
    MATCH_6(6, 2000000000);

    private final int match;
    private final int money;

    LottoGame(int match, int money){
        this.match = match;
        this.money = money;
    }
}
