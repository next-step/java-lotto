package lotto.view.resultview;

import lotto.domain.Lottos;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.WinningRank;
import lotto.dto.WinningStatistic;

import java.util.EnumSet;
import java.util.Set;

public class ConsoleResultView implements ResultView {
    @Override
    public void printBoughtLottos(ManualLottoNumbers manualLottoNumbers, Lottos boughtLottos) {
        StringBuilder sb = new StringBuilder();

        String purchaseMsg = String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualLottoNumbers.size(), boughtLottos.size() - manualLottoNumbers.size());
        sb.append(purchaseMsg).append(System.lineSeparator());

        boughtLottos.labelNumbers((numbers) -> sb.append(numbers).append(System.lineSeparator()));

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
        Set<WinningRank> winningRanks = EnumSet.allOf(WinningRank.class);
        winningRanks.stream()
                .filter(r -> r.getWinningAmount() > 0)
                .map(r -> getStatisticFrom(winningStatistic, r))
                .forEach(s -> sb.append(s).append(System.lineSeparator()));
    }

    private String getStatisticFrom(WinningStatistic winningStatistic, WinningRank winningRank) {
        return String.format("%s개 일치%s (%d원) - %d개",
                winningRank.getWinningCondition().getMatchedCount(),
                winningRank.getWinningCondition().isBonusNumMatched() ? ", 보너스 볼 일치" : "",
                winningRank.getWinningAmount(),
                winningStatistic.getCountOfWinningRank(winningRank));
    }

    private void appendEarningRate(WinningStatistic winningStatistic, StringBuilder sb) {
        sb.append("총 수익률은 ").append(winningStatistic.getEarningsRate()).append("입니다.");
    }
}