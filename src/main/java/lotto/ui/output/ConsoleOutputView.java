package lotto.ui.output;

import lotto.model.Lottos;
import lotto.model.Statistics;

public class ConsoleOutputView implements OutputView{

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
        statistics.foreach((o) -> {
            sb.append(o).append(NEW_LINE);
        });
        System.out.println(sb);
    }
}
