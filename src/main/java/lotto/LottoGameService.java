package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameService {
    private static final int lottoPrice = 1000;
    private static int lottoBuyAmt = 0;
    private static int lottoBuyCnt = 0;
    private static int[] winnerLottoNumbers;
    private static List<Lotto> buyLotto = new ArrayList<>();

    public static void setLottoBuyAmt(int lottoBuyAmt) {
        LottoGameService.lottoBuyAmt = lottoBuyAmt;
    }

    public static void setWinnerLottoNumbers(int[] winnerLottoNumbers) {
        LottoGameService.winnerLottoNumbers = winnerLottoNumbers;
    }

    public static List<Lotto> getBuyLotto() {
        return buyLotto;
    }

    public static void setBuyLotto(List<Lotto> buyLotto) {
        LottoGameService.buyLotto = buyLotto;
    }

    public static int getLottoBuyAmt() {
        return lottoBuyAmt;
    }

    public static int buyLotto(int lottoBuyAmt){
        int lottoQty = 0;
        lottoQty = lottoBuyAmt/lottoPrice;
        System.out.println(lottoQty+"개를 구매했습니다.");
        lottoBuyCnt = lottoQty;
        for(int i=0; i< lottoBuyCnt; i++){
            Lotto lotto = new Lotto(true);
            buyLotto.add(lotto);
            PrintView.printLottoNumber(lotto);
        }
        return lottoQty;
    }


    public static void matchingWinnerNumber(){
        for(Lotto lotto : buyLotto){
            int matchCnt = getMatchLottoCnt(lotto);
            lotto.setWinnerMatchCnt(matchCnt);
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

    public static int getLottoMatchStatistics(int matchCnt){
        int matchLottoCnt = 0;
        for(Lotto lotto : buyLotto){
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
