package lotto;

import java.util.List;

public class PrintView {

    public static final String LOTTO_BUY_QTY_MESSAGE = "개를 구매했습니다.";

    public static void printLottoNumber(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getLottoNumbers());
        }

    }

    public static void printLottoStatistics(List<Rank> rankList) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        for(int i=3; i<=6; i++){
            System.out.println(Rank.getRankByMatchCnt(i).getMatchCnt()+"개 일치 ("+Rank.getRankByMatchCnt(i).getWinnnerPrice()+"원)- "+LottoGameService.getLottoMatchStatistics(rankList, i)+"개");
        }
    }

    public static void printWinnerLate(LottoTicket lottoTicket) {
        double profitRate = Profit.getLottoGameProfit(lottoTicket);
        System.out.println("총 수익률은 "+profitRate+"입니다.(기준이 1이기 때문에 결과적으로 "+profitToString(profitRate)+"라는 의미임)");
    }

    public static void printBuyLottoQty(int lottoQty){
        System.out.println(lottoQty+ LOTTO_BUY_QTY_MESSAGE);
    }

    public static String profitToString(double profitRate) {
        if (profitRate >= 1) {
            return "이득이";
        }
        return "손해";
    }

}
