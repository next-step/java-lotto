package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static void outputPurchaseQuantity(LottoTicket ticket) {
        System.out.println("수동으로 " + ticket.getManualCount() + "장, 자동으로 " + ticket.getRemainCount() + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        IntStream.range(0, lottos.quantity())
                .forEach(i -> System.out.println(lottos.getLotto(i).stream()
                        .map(lottonumber -> lottonumber.getNumber())
                        .sorted()
                        .collect(Collectors.toList())));
    }

    public static void outputPrizeStatistics(Reward reward) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<PrizeInformation, Integer> rewardResult = reward.getRewardResult();
        for (PrizeInformation prize : PrizeInformation.values()) {
            System.out.println(prize.countMatchNumber() + "개 일치" + isBonusball(prize) + "(" + prize.getPrizePrice() + "원)-" + rewardResult.get(prize) + "개");
        }

    }

    private static String isBonusball(PrizeInformation prizeInformation) {
        return prizeInformation.getMatchStatus().isBonusball() ? ", 보너스 볼 일치" : "";
    }


    public static void outputTotalEarningRate(Reward reward, Money purchasePrice) {
        System.out.println("총 수익률은 " + FORMAT.format(reward.earningRate(purchasePrice.getPurchasePrice())) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}