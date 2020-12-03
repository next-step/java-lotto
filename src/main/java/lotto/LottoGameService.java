package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {
    private static final int lottoPrice = 1000;
    private static int lottoBuyAmt = 0;
    private static int lottoBuyCnt = 0;
    private static LottoTicket buyLotto;

    public LottoGameService(LottoTicket lottoTicket) {
        buyLotto = lottoTicket;
    }

    public static void setLottoBuyAmt(int lottoBuyAmt) {
        LottoGameService.lottoBuyAmt = lottoBuyAmt;
    }

    public static int getLottoBuyAmt() {
        return lottoBuyAmt;
    }

    public static LottoTicket buyLotto(int lottoBuyAmt){
        setLottoBuyAmt(lottoBuyAmt);
        int lottoQty = 0;
        lottoQty = lottoBuyAmt/lottoPrice;
        lottoBuyCnt = lottoQty;
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i< lottoBuyCnt; i++){
            Lotto lotto = new Lotto(true);
            lottoList.add(lotto);
        }
        buyLotto = new LottoTicket(lottoList);
        return buyLotto;
    }

    public static int getLottoMatchStatistics(List<Rank> rankList, Rank rank){
        int matchLottoCnt = 0;
        for(Rank r : rankList){
            matchLottoCnt = r.equals(rank) ? ++matchLottoCnt : matchLottoCnt;
        }
        return matchLottoCnt;
    }
}
