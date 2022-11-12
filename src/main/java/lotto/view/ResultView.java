package lotto.view;

import java.text.MessageFormat;
import lotto.domain.AccordanceCount;
import lotto.domain.Lottos;

public class ResultView {

    public void printPurchaseQuantity(Lottos lottos, int manualLottoCount) {
        System.out.println(System.lineSeparator() + MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.", manualLottoCount, lottos.getCount() - manualLottoCount));
    }

    public void printEachLotto(Lottos lottos) {
        lottos.getLottos()
            .forEach(lotto -> System.out.println("[" + lotto + "]"));
    }

    public void printWinningStatistics(AccordanceCount accordanceCount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("당첨 통계");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("---------");
        stringBuilder.append(System.lineSeparator());

        accordanceCount.getCountsByWinningAccordanceInSequence()
            .forEach(entry -> stringBuilder.append(MessageFormat.format(
                    "{0}개 일치 ({1}원)- {2}개",
                    entry.getKey().getMatchCount(),
                    entry.getKey().getPrize(),
                    entry.getValue()))
                .append(System.lineSeparator())
            );

        System.out.println(stringBuilder);
    }

    public void printProfitRatio(double profitRatio) {
        System.out.println(MessageFormat.format("총 수익률은 {0}입니다.", profitRatio));
    }
}
