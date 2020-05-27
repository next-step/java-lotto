package step2;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    private ResultView() {}

    public static ResultView create() {
        return new ResultView();
    }

    public void printNumber(LottoGame lottoGame) {
        List<Lotto> lottos = lottoGame.getLottos();
        System.out.println();
        lottos.forEach(this::printNumber);
    }

    private void printNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printStatistics(LottoGame lottoGame) {
        HashMap matchedNumberMap = lottoGame.getMatchedNumberMap();
        System.out.println("당청통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + matchedNumberMap.getOrDefault(3,0));
        System.out.println("4개 일치 (50000원)- " + matchedNumberMap.getOrDefault(4,0));
        System.out.println("5개 일치 (1500000원)- " + matchedNumberMap.getOrDefault(5,0));
        System.out.println("6개 일치 (2000000000원)- " + matchedNumberMap.getOrDefault(6,0));
    }
}
