package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.PrizeStatus;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {


    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static void outputPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void outputExchangeLottos(Lottos lottos) {
        IntStream.range(0, lottos.hasLottoSize())
                .forEach(i -> System.out.println(lottos.getLottoNumber(i)));
    }

    public static void outputPrizeStatistics(Map<PrizeStatus, Integer> prizeStatuses) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)-" + (prizeStatuses.get(new PrizeStatus(3)) == null? 0: prizeStatuses.get(new PrizeStatus(3)) ) + "개");
        System.out.println("4개 일치 (50000원)-" + (prizeStatuses.get(new PrizeStatus(4)) == null? 0: prizeStatuses.get(new PrizeStatus(4)) )+ "개");
        System.out.println("5개 일치 (150000원)-" + (prizeStatuses.get(new PrizeStatus(5)) == null? 0: prizeStatuses.get(new PrizeStatus(5)) )+ "개");
        System.out.println("6개 일치 (2000000000원)-" + (prizeStatuses.get(new PrizeStatus(6)) == null? 0: prizeStatuses.get(new PrizeStatus(6)) )+ "개");

    }

    public static void outputTotalEarningRate(Lottos lottos, int purchasePrice){
        System.out.println("총 수익률은 "+FORMAT.format(lottos.earningRate(purchasePrice))+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
