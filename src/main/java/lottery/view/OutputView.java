package lottery.view;

import lottery.domain.LotteryNumbers;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private final PrintStream out;

    public OutputView() {
        this(System.out);
    }

    public OutputView(PrintStream out) {
        this.out = out;
    }

    public void showLotteries(List<LotteryNumbers> lotteries) {
        out.format("%1$d개를 구매했습니다.", lotteries.size());
        out.println();
        lotteries.forEach(this::showLotteryNumbers);
    }

    private void showLotteryNumbers(LotteryNumbers lotteryNumbers) {
        out.print("[");
        out.print(lotteryNumbers.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")));
        out.println("]");
    }

    public void showWinnings(long spent, Map<Integer, Long> winningResult) {
        long earned = 0;

        out.println("당첨 통계");
        out.println("---------");
        for(WinningType winningType : WinningType.values()) {
            long countMatched = winningResult.getOrDefault(winningType.matches, 0L);
            earned += winningType.earning * countMatched;
            out.format("%1$d개 일치 (%2$d)원- %3$d개", winningType.matches, winningType.earning, countMatched);
            out.println();
        }
        out.format("총 수익률은 %1$.2f입니다.", (double)earned / spent);
        out.println();
    }

    enum WinningType {
        fifth( 3, 5000),
        fourth(4, 50000),
        third( 5, 1500000),
        first( 6, 2000000000);

        private final int matches;
        private final int earning;

        WinningType(int matches, int earning) {
            this.matches = matches;
            this.earning = earning;
        }
    }
}
