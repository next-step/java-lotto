package edu.nextstep.lotto.step2.view;

import edu.nextstep.lotto.step2.domain.LottoList;
import edu.nextstep.lotto.step2.domain.WinningAmount;
import edu.nextstep.lotto.step2.domain.WinningList;

public class ResultView {

    private static final String NEW_LINE = "\n";

    public void outputNumberOfPurchase(LottoList lottoList) {
        System.out.printf("%s 개를 구매했습니다.%n", lottoList.getLottoList().size());
    }

    public void outputLottoList(LottoList lottoList) {
        lottoList.getLottoList().forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
        System.out.print(NEW_LINE);
    }

    public void outputStatistics(LottoList lottoList, WinningList winningList) {
        System.out.printf("3개 일치 (5000원)- %s개%n", lottoList.getMatchResult(winningList, WinningAmount.FOURTH.getCount()));
        System.out.printf("4개 일치 (50000원)- %s개%n", lottoList.getMatchResult(winningList, WinningAmount.THIRD.getCount()));
        System.out.printf("5개 일치 (1500000원)- %s개%n", lottoList.getMatchResult(winningList, WinningAmount.SECOND.getCount()));
        System.out.printf("6개 일치 (2000000000원)- %s개%n", lottoList.getMatchResult(winningList, WinningAmount.FIRST.getCount()));
    }

    public void outputRate(LottoList lottoList, WinningList winningList, int purchaseAmount) {
        float rate = lottoList.getRate(winningList, purchaseAmount);

        System.out.printf("총 수익률은 %.2f 입니다.", rate);

        if (rate < 1) {
            System.out.print(" (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
