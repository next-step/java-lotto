package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LottoWinner {
    private final int[] winnerLottoNumbers;

    public LottoWinner(int[] winnerLottoNumbers) {
        this.winnerLottoNumbers = winnerLottoNumbers;
    }

    public List<Rank> matchingWinnerNumber(LottoTicket lottoTicket){
        List<Rank> lottoRankList = new ArrayList<>();
        for(Lotto lotto : lottoTicket.getLottoList()){
            int matchCnt = getMatchLottoCnt(lotto);
            lotto.addWinnerMatchCnt(matchCnt);
            lottoRankList.add(Rank.getRankByMatchCnt(matchCnt));
        }
        return lottoRankList;
    }

    public int getMatchLottoCnt(Lotto lotto) {
        return Arrays.stream(this.winnerLottoNumbers).map(i -> {
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
