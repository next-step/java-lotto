package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameService {
    private static final int lottoPrice = 1000;
    private static int lottoBuyAmt = 0;
    private static int lottoBuyCnt = 0;
    private static LottoTicket buyLotto;

    public static void setBuyLotto(LottoTicket buyLotto) {
        LottoGameService.buyLotto = buyLotto;
    }

    public static LottoTicket getBuyLotto() {
        return buyLotto;
    }
    public static void setLottoBuyAmt(int lottoBuyAmt) {
        LottoGameService.lottoBuyAmt = lottoBuyAmt;
    }


    public static int getLottoBuyAmt() {
        return lottoBuyAmt;
    }

    public static int buyLotto(int lottoBuyAmt){
        setLottoBuyAmt(lottoBuyAmt);
        int lottoQty = 0;
        lottoQty = lottoBuyAmt/lottoPrice;
        PrintView.printBuyLottoQty(lottoQty);
        lottoBuyCnt = lottoQty;
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i< lottoBuyCnt; i++){
            Lotto lotto = new Lotto(true);
            lottoList.add(lotto);
            PrintView.printLottoNumber(lotto);
        }
        buyLotto = new LottoTicket(lottoList);
        return lottoQty;
    }

    public static int getLottoMatchStatistics(int matchCnt){
        int matchLottoCnt = 0;
        for(Lotto lotto : buyLotto.getLottoList()){
            matchLottoCnt = getMatchRankLottoCnt(matchCnt, matchLottoCnt, lotto);
        }
        return matchLottoCnt;
    }

    public static int getMatchRankLottoCnt(int matchCnt, int matchLottoCnt, Lotto lotto) {
        if(getResultRank(lotto).getMatchCnt() == matchCnt){
            matchLottoCnt++;
        }
        return matchLottoCnt;
    }

    public static Rank getResultRank(Lotto lotto){
        return Rank.getRankByMatchCnt(lotto.getWinnerMatchCnt());
    }
}
