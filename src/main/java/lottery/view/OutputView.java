package lottery.view;

import lottery.domain.LotteryNumber;
import lottery.domain.Lottery;
import lottery.domain.WinningType;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private final PrintStream out = System.out;

    public void showLotteries(List<Lottery> lotteries) {
        out.format("%1$d개를 구매했습니다.", lotteries.size());
        out.println();
        lotteries.forEach(this::showLotteryNumbers);
    }

    private void showLotteryNumbers(Lottery lottery) {
        out.format(
                "[%s]",
                lottery.getNumbers()
                        .stream()
                        .map(LotteryNumber::toString)
                        .collect(Collectors.joining(", "))
        );
        out.println();
    }

    public void showWinnings(long spent, Map<WinningType, Long> winningResult) {
        long earned = 0;

        out.println("당첨 통계");
        out.println("---------");
        for(WinningType winningType : WinningType.values()) {
            long countMatched = winningResult.getOrDefault(winningType, 0L);
            earned += winningType.getEarning() * countMatched;
            out.format("%1$d개 일치%4$s(%2$d)원- %3$d개"
                    , winningType.getMatches()
                    , winningType.getEarning()
                    , countMatched
                    , winningType.hasBonus() ? ", 보너스 볼 일치" : " "
            );
            out.println();
        }
        out.format("총 수익률은 %1$.2f입니다.", (double)earned / spent);
        out.println();
    }
}
