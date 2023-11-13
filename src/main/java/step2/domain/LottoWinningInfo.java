package step2.domain;

public enum LottoWinningInfo {
    MATCH_THREE(3,5_000),
    MATCH_FOUR(4,50_000),
    MATCH_FIVE(5,1_500_000),
    MATCH_SIX(6,2_000_000_000);

    private final int matchCount;
    private final int winningMoney;

    LottoWinningInfo(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static int winningMoney(int matchCount){
        for(LottoWinningInfo lottoWinningInfo: LottoWinningInfo.values()){
            if(lottoWinningInfo.matchCount == matchCount){
                return lottoWinningInfo.winningMoney;
            }
        }
        throw new IllegalArgumentException("당첨금을 찾을 수 없습니다. 입력 matchCount : " + matchCount);
    }

    public static Integer matchCount(int matchCount) {
        for(LottoWinningInfo lottoWinningInfo: LottoWinningInfo.values()){
            if(lottoWinningInfo.matchCount == matchCount){
                return lottoWinningInfo.matchCount;
            }
        }
        throw new IllegalArgumentException("당첨 매칭 갯수를 찾을 수 없습니다. 입력 matchCount : " + matchCount);
    }
}
