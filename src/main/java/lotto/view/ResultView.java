package lotto.view;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoScore;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoMatcher.*;
import static lotto.LottoMatcher.FIRST_MATCH;

public class ResultView {
    public void view(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            List<Integer> integers = lotto.lottoNumbers()
                    .stream()
                    .map(LottoNumber::intValue)
                    .collect(Collectors.toList());
            System.out.println(integers);
        });

    }
    public void result(LottoScore lottoScore) {
        System.out.println("당첨 통계");
        System.out.printf("3개 일치 (%d원)- %d개\n", FOURTH_MATCH.price(), lottoScore.fourthCount());
        System.out.printf("4개 일치 (%d원)- %d개\n", THIRD_MATCH.price(), lottoScore.thirdCount());
        System.out.printf("5개 일치 (%d원)- %d개\n", SECOND_MATCH.price(), lottoScore.secondCount());
        System.out.printf("6개 일치 (%d원)- %d개\n", FIRST_MATCH.price(), lottoScore.firstCount());
        System.out.printf("총 수익률은 %f입니다.\n", lottoScore.rate());
    }
}
