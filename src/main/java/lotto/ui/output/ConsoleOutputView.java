package lotto.ui.output;

import lotto.model.Lottos;
import lotto.model.Statistics;

import java.util.List;

public class ConsoleOutputView implements OutputView{

    private static final List<String> MATCH_STATIC_MESSAGES = List.of("3개 일치 (5000원)- %d개", "4개 일치 (50000원)- %d개", "5개 일치 (1500000원)- %d개", "6개 일치 (2000000000원)- %d개");
    public static final String PROFIT_STATIC_MESSAGE = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static final String LOTTO_SIZE_POSTFIX_MESSAGE = "개를 구매했습니다.";
    public static final String NEW_LINE = "\n";

    @Override
    public void printLotto(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append(LOTTO_SIZE_POSTFIX_MESSAGE).append(NEW_LINE);
        lottos.foreach((o) -> {
            sb.append(o).append(NEW_LINE);
        });
        System.out.println(sb);
    }

    @Override
    public void printStatistics(Statistics statistics) {
        StringBuilder sb = new StringBuilder();
        statistics.forEachMatchingCount((i, o) -> {
            sb.append(String.format(MATCH_STATIC_MESSAGES.get(i), o)).append(NEW_LINE);
        });
        statistics.applyToProfit((o) -> {
            sb.append(String.format(PROFIT_STATIC_MESSAGE, o));
        });
        System.out.println(sb);
    }
}
