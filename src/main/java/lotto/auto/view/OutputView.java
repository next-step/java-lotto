package lotto.auto.view;

import lotto.auto.domain.LottoHandler;
import lotto.auto.domain.Lottos;
import lotto.auto.domain.Win;
import lotto.auto.vo.Money;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String RESPONSE_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_STATS = "당첨 통계";
    private static final String SEPARATOR = "---------";
    public void print(String endValue) {
        System.out.println(endValue);
    }
    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }
    public void printPurchase(int count) {
        System.out.println(count + RESPONSE_PURCHASE_MESSAGE);
    }
    public void printWinResult(Money money, List<Win> wins) {
        System.out.println(WIN_STATS);
        System.out.println(SEPARATOR);
        List<String> results = makePlaceMessage(wins);
        results.forEach(this::print);
        printRate(money, wins);
    }
    private void printRate(Money money, List<Win> wins) {
        LottoHandler lottoHandler = new LottoHandler();
        Double returnPercent = lottoHandler.getReturn(money, wins);
        print("총 수익률은 " + returnPercent + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
    private static List<String> makePlaceMessage(List<Win> wins) {
        return List.of(Win.FIFTH.getMatchNumber() + "개 일치 (" + Win.FIFTH.getReward() + "원)-" + Collections.frequency(wins, Win.FIFTH) + "개",
                Win.FOURTH.getMatchNumber() + "개 일치 (" + Win.FOURTH.getReward() + "원)-" + Collections.frequency(wins, Win.FOURTH) + "개",
                Win.THIRD.getMatchNumber() + "개 일치 (" + Win.THIRD.getReward() + "원)-" + Collections.frequency(wins, Win.THIRD) + "개",
                Win.SECOND.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + Win.SECOND.getReward() + "원)-" + Collections.frequency(wins, Win.SECOND) + "개",
                Win.FIRST.getMatchNumber() + "개 일치 (" + Win.FIRST.getReward() + "원)-" + Collections.frequency(wins, Win.FIRST) + "개");
    }

}
