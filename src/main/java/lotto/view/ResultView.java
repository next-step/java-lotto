package lotto.view;

import lotto.RewardPrice;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.RewardPrice.*;

public class ResultView {

    private ResultView() {
    }

    public static void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(Arrays.toString(lotto.getLottoNumbers().toArray())));
    }

    public static void printLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printStatistics(Map<RewardPrice, Integer> statistics, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        statistics.forEach((rewardPrice, count) -> System.out.println(rewardPrice.getCount() + "개 일치 (" + rewardPrice.getPrice() + "원) - " + count + "개"));
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfReturn) + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }


}
