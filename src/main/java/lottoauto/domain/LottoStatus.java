package lottoauto.domain;

/**
 *     public static final int THREE_MATCH_WINNING_MONEY = 5000;
 *     public static final int FOUR_MATCH_WINNING_MONEY = 50000;
 *     public static final int FIVE_MATCH_WINNING_MONEY = 1500000;
 *     public static final int SIX_MATCH_WINNING_MONEY = 2000000000;
 */
public enum LottoStatus {
    MatchThree, MatchFour, MatchFive, MatchSix, Nothing;

    public int lottoMoney(LottoStatus status){
        if(status == MatchThree) return 5000;
        if(status == MatchFour) return 50000;
        if(status == MatchFive) return 1500000;
        if(status == MatchSix) return 2000000000;
        return 0;
    }
}
