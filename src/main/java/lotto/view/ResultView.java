package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println("[" + String.join(",", lotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .map(Object::toString)
                .collect(Collectors.toList())) + "]");
    }

    public static void printResults(List<LottoResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + Collections.frequency(results, LottoResult.FOURTH_PRIZE));
        System.out.println("4개 일치 (50000원)- " + Collections.frequency(results, LottoResult.THIRD_PRIZE));
        System.out.println("5개 일치 (1500000원)- " + Collections.frequency(results, LottoResult.SECOND_PRIZE));
        System.out.println("6개 일치 (2000000000원)- " + Collections.frequency(results, LottoResult.FIRST_PRIZE));
    }

    public static void printYield(double calculateYield) {
        System.out.println("총 수익률은 " + String.format("%.2f", calculateYield) + "입니다");
    }
}
