package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Prizes;

public class OutputView {

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos.value()) {
            String lottoStr = lotto.balls().stream().mapToInt(Ball::number)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoStr);
        }
    }

    public void printJudgeResult(int usedMoney, Prizes prizes) {
        System.out.println("당첨 통계\n---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", prizes.count(Prize.MATCHING_THREE));
        System.out.printf("4개 일치 (50000원)- %d개\n", prizes.count(Prize.MATCHING_FOUR));
        System.out.printf("5개 일치 (1500000원)- %d개\n", prizes.count(Prize.MATCHING_FIVE));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", prizes.count(Prize.MATCHING_SIX));

        System.out.printf("총 수익률은 %.2f입니다.", prizes.calcReturnRate(usedMoney));
    }
}
