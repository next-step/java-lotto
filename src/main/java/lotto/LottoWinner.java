package lotto;

import java.util.ArrayList;
import java.util.List;

public final class LottoWinner {
    private final Lotto winnerLotto;
    private final LottoNumber bonusLottoNumber;

    private LottoWinner(LottoNumber[] winnerLotto, LottoNumber bonusLottoNumber) {
        this.winnerLotto = Lotto.of(winnerLotto);
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static LottoWinner of(LottoNumber[] winnerLotto, LottoNumber bonusLottoNumber){
        return new LottoWinner(winnerLotto, bonusLottoNumber);
    }



    public List<Rank> matchingWinnerNumber(LottoTicket lottoTicket){
        List<Rank> lottoRankList = new ArrayList<>();
        for(Lotto lotto : lottoTicket.getLottoList()){
            int matchCnt = getMatchLottoCnt(lotto);
            lottoRankList.add(Rank.valueOf(matchCnt, lotto.isContainLottoNumber(bonusLottoNumber)));
        }
        return lottoRankList;
    }

    public int getMatchLottoCnt(Lotto lotto) {
        return winnerLotto.getLottoNumbers().stream().mapToInt(lottoNumber -> {
            return lotto.judgeWinnerNumber(lottoNumber);
        }).sum();
    }
}
