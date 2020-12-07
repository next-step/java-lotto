package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PrintView {

    public static final String LOTTO_BUY_QTY_MESSAGE = "개를 구매했습니다.";

    public static void printLottoNumber(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getLottoNumbers().toString());
        }

    }

    public static void printLottoStatistics(List<Rank> rankList) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        Arrays.stream(Rank.values())
        .sorted(Comparator.comparing(Rank::getWinnnerPrice))
        .filter(r -> r.getMatchCnt() != 0)
        .forEach(r -> {
            System.out.println(printBallMatchCnt(r)+r.getWinnnerPrice()+"원)- "+LottoGameService.getLottoMatchStatistics(rankList, r)+"개");
        });
    }

    public static String printBallMatchCnt(Rank rank) {
        if(rank.equals(Rank.SECOND)){
            return rank.getMatchCnt()+"개 일치, 보너스 볼 일치(";
        }
        return rank.getMatchCnt()+"개 일치 (";
    }

    public static void printWinnerLate(List<Rank> lottoRankList) {
        double profitRate = Profit.getLottoGameProfit(lottoRankList);
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
