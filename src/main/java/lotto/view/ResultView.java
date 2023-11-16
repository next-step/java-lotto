package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.RewardPrice.*;
import static lotto.RoRCalculator.calculateYield;

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

    public static void printStatistics(int [] statistics, int lottoCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(MATCH_3.getCount() + "개 일치 (" + MATCH_3.getPrice() + "원) - " + statistics[MATCH_3.getCount()] + "개");
        System.out.println(MATCH_4.getCount() + "개 일치 (" + MATCH_4.getPrice() + "원) - " + statistics[MATCH_4.getCount()] + "개");
        System.out.println(MATCH_5.getCount() + "개 일치 (" + MATCH_5.getPrice() + "원) - " + statistics[MATCH_5.getCount()] + "개");
        System.out.println(MATCH_6.getCount() + "개 일치 (" + MATCH_6.getPrice() + "원) - " + statistics[MATCH_6.getCount()] + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", calculateYield(statistics, lottoCount)) + "입니다.");
    }


}
