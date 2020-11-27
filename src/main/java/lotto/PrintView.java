package lotto;

public class PrintView {

    public static final String LOTTO_BUY_QTY_MESSAGE = "개를 구매했습니다.";

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    public static void printLottoStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)- "+LottoGameService.getLottoMatchStatistics(3)+"개");
        System.out.println("4개 일치 (50000원)- "+LottoGameService.getLottoMatchStatistics(4)+"개");
        System.out.println("5개 일치 (1500000원)- "+LottoGameService.getLottoMatchStatistics(5)+"개");
        System.out.println("6개 일치 (2000000000원)- "+LottoGameService.getLottoMatchStatistics(6)+"개");
    }

    public static void printWinnerLate() {
        double profitRate = Profit.getLottoGameProfit();
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
