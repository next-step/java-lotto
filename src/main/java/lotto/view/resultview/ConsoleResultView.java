package lotto.view.resultview;

import lotto.Lotto;
import lotto.WinningRank;
import lotto.WinningStatistic;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ConsoleResultView implements ResultView {
    @Override
    public void printBoughtLottos(List<Lotto> boughtLottos) {
        StringBuilder sb = new StringBuilder();

        sb.append(boughtLottos.size()).append("개를 구매했습니다.").append(System.lineSeparator());

        for (Lotto boughtLotto : boughtLottos) {
            Set<Integer> numbers = boughtLotto.getNumbers();
            sb.append(numbers.toString()).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

    @Override
    public void printWinningStatistic(WinningStatistic winningStatistic) {
        StringBuilder sb = new StringBuilder();

        appendHeader(sb);
        appendStatistics(winningStatistic, sb);
        appendEarningRate(winningStatistic, sb);

        System.out.println(sb.toString());
    }

    private void appendHeader(StringBuilder sb) {
        sb.append("당첨 통계").append(System.lineSeparator());
        sb.append("---------").append(System.lineSeparator());
    }

    private void appendStatistics(WinningStatistic winningStatistic, StringBuilder sb) {
        EnumSet<WinningRank> winningRanks = EnumSet.allOf(WinningRank.class);
        winningRanks.stream()
                .filter(r -> r.getWinningAmount() > 0)
                .map(r -> String.format("%s (%d원) - %d개", r.getDescription(), r.getWinningAmount(), winningStatistic.getCountOfWinningRank(r)))
                .forEach(s -> sb.append(s).append(System.lineSeparator()));
    }

    private void appendEarningRate(WinningStatistic winningStatistic, StringBuilder sb) {
        sb.append("총 수익률은 ").append(winningStatistic.getEarningsRate()).append("입니다.");
    }
}