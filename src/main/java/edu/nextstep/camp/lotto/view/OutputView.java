package edu.nextstep.camp.lotto.view;

import java.util.stream.Collectors;

import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;
import edu.nextstep.camp.lotto.domain.Prize;
import edu.nextstep.camp.lotto.domain.PurchaseList;

public class OutputView {
    public static void printPurchasedLotto(PurchaseList purchaseList) {
        System.out.printf("%d장을 구입했습니다.\n", purchaseList.amount());

        for(Lotto lotto : purchaseList.collect()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        String lottoString = lotto.collect()
                .stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","));
        System.out.println("[" + lottoString + "]");
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Prize.FOURTH_PRIZE + "원)-" + gameResult.fourthPlace());
        System.out.println("4개 일치 (" + Prize.THIRD_PRIZE + "원)-" + gameResult.thirdPlace());
        System.out.println("5개 일치 (" + Prize.SECOND_PRIZE + "원)-" + gameResult.secondPlace());
        System.out.println("6개 일치 (" + Prize.FIRST_PRIZE + "원)-" + gameResult.firstPlace());
        System.out.println("총 상금: " + gameResult.totalPrize());
    }

    public static void printPriceEarningRate(float rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
