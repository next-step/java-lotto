package lotto.view;

import java.text.MessageFormat;
import lotto.domain.AccordanceCount;
import lotto.domain.Lottos;

public class ResultView {

    public void printLottos(Lottos lottos) {
        printPurchaseQuantity(lottos);
        printEachLotto(lottos);
    }

    private void printPurchaseQuantity(Lottos lottos) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottos.getCount()));
    }

    private void printEachLotto(Lottos lottos) {
        lottos.getLottos()
            .forEach(lotto -> System.out.println("[" + lotto + "]"));
    }

    public void printWinningStatistics(AccordanceCount accordanceCount) {
        accordanceCount.getCountsByWinningAccordanceInSequence()
            .forEach(entry -> System.out.println(MessageFormat.format(
                "{0}개 일치 ({1}원)- {2}개",
                entry.getKey().getMatchCount(),
                entry.getKey().getPrize(),
                entry.getValue()
            )));
    }

    public void printProfitRatio(double profitRatio) {
        System.out.println(MessageFormat.format("총 수익률은 {0}입니다.", profitRatio));
    }
}
