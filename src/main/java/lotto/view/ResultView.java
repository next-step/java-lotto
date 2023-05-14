package lotto.view;

import lotto.domain.LottoScore;

import java.util.List;

import static lotto.domain.LottoMatcher.*;

public class ResultView {
    public void view(List<List<Integer>> lottos) {
        lottos.forEach(lottoNumbers -> System.out.println(lottoNumbers));
    }

    public void result(LottoScore lottoScore) {
        System.out.println("당첨 통계");
        System.out.printf("3개 일치 (%d원)- %d개\n", FIFTH_MATCH.price(), lottoScore.fifthCount());
        System.out.printf("4개 일치 (%d원)- %d개\n", FOURTH_MATCH.price(), lottoScore.fourthCount());
        System.out.printf("5개 일치 (%d원)- %d개\n", THIRD_MATCH.price(), lottoScore.thirdCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원)- %d개\n", SECOND_MATCH.price(), lottoScore.secondCount());
        System.out.printf("6개 일치 (%d원)- %d개\n", FIRST_MATCH.price(), lottoScore.firstCount());
    }

    public void rate(double rate) {
        System.out.printf("총 수익률은 %f입니다.\n", rate);
    }
}
