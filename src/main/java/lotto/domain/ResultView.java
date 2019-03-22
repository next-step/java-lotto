package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public void printLotto(List<Integer> numbers) {
        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public void printLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Lottos lottoList = new Lottos(lottos);
        System.out.print("3개 일치 (5000원) - ");
        System.out.println(lottoList.rankCount(winningLotto, Winning.FOURTH.getRank()));
        System.out.print("4개 일치 (50000원) - ");
        System.out.println(lottoList.rankCount(winningLotto, Winning.THIRD.getRank()));
        System.out.print("5개 일치 (1500000원) - ");
        System.out.println(lottoList.rankCount(winningLotto, Winning.SECOND.getRank()));
        System.out.print("6개 일치 (2000000000원) - ");
        System.out.println(lottoList.rankCount(winningLotto, Winning.FIRST.getRank()));
    }

    public void printEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
