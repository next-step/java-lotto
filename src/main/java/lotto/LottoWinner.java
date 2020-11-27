package lotto;

import java.util.Arrays;

public class LottoWinner {
    private static int[] winnerLottoNumbers;

    public static void setWinnerLottoNumbers(int[] winnerLottoNumbers) {
        LottoWinner.winnerLottoNumbers = winnerLottoNumbers;
    }

    public static void matchingWinnerNumber(){
        for(Lotto lotto : LottoGameService.getBuyLotto().getLottoList()){
            int matchCnt = getMatchLottoCnt(lotto);
            lotto.addWinnerMatchCnt(matchCnt);
            lotto.setRank(Rank.getRankByMatchCnt(matchCnt));
        }
    }

    public static int getMatchLottoCnt(Lotto lotto) {
        return Arrays.stream(winnerLottoNumbers).map(i -> {
            return judgeWinnerNumber(lotto, i);
        }).sum();
    }

    public static Integer judgeWinnerNumber(Lotto lotto, int i) {
        if(lotto.getLottoNumbers().contains(i)){
            return 1;
        }
        return 0;
    }
}
