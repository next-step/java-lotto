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

    public static LottoTicket autoBuyLotto(int lottoBuyAmt, LottoTicket manualBuyLottoTicket){
        setLottoBuyAmt(lottoBuyAmt);
        lottoBuyCnt = (lottoBuyAmt/lottoPrice)-manualBuyLottoTicket.getLottoTicketSize();
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i< lottoBuyCnt; i++){
            Lotto lotto = Lotto.from();
            lottoList.add(lotto);
        }
        buyLotto = LottoTicket.from(lottoList);
        return buyLotto;
    }

    public static int getLottoMatchStatistics(List<Rank> rankList, Rank matchRank){
        int matchLottoCnt = 0;
        for(Rank rank : rankList){
            matchLottoCnt = rank.equals(matchRank) ? ++matchLottoCnt : matchLottoCnt;
        }
        return matchLottoCnt;
    }
}
