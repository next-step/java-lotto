package lotto.view;

import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.Reward;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class ResultView {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static void outputPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        IntStream.range(0, lottos.quantity())
                .forEach(i -> System.out.println(lottos.getLottoNumber(i)));
    }

    public static void outputPrizeStatistics(Reward reward) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        reward.getRewardResult()
                .forEach((prize, count) -> System.out.println(prize.getMatchNumberCount()+"개 일치 ("+prize.getPrizePrice()+")-"+count+"개"));
    }

    public static void outputTotalEarningRate(Reward reward, LottoPrice purchasePrice) {
        System.out.println("총 수익률은 "+FORMAT.format(reward.earningRate(purchasePrice.getPurchasePrice()))+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}