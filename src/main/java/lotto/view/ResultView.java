package lotto.view;

import lotto.domain.AccordanceCount;
import lotto.domain.Lottos;

import java.text.MessageFormat;
import java.util.stream.Collectors;

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
                .forEach(lotto -> System.out.println( "[" + lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) + "]" ));
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
