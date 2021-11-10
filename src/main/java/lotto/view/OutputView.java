package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OutputView {

    private static final String WINNING_HISTORY_PRINT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String YIELD_MORE_ONE_PRINT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String YIELD_LESS_ONE_PRINT_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void renderWithLottos(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
        printLottos(lottos);
    }

    private void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> printLotto(lotto));
    }

    private void printLotto(Lotto lotto) {
        String collect = lotto.getLottoNumbers().stream()
                .map(num -> String.valueOf(num.getValue()))
                .collect(Collectors.joining(","));
        System.out.println("[" + collect + "]");
    }

    public void renderWithWinningHistory(WinningHistory winningHistory, List<WinningRank> winningRanks) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printHistory(createWinningHistoryMap(winningHistory), winningRanks);
        System.out.println(getPrintFormatWithYield(winningHistory));
    }

    private String getPrintFormatWithYield(WinningHistory winningHistory) {
        Money originMoney = winningHistory.getOriginMoney();
        Money winningMoney = winningHistory.getWinningMoney();

        double yield = winningMoney.divide(originMoney);
        if (yield < 1) {
            return String.format(YIELD_LESS_ONE_PRINT_FORMAT, yield);
        }
        return String.format(YIELD_MORE_ONE_PRINT_FORMAT, yield);
    }

    private void printHistory(Map<WinningRank, Long> winningMap, List<WinningRank> winningRanks) {
        for (WinningRank winningRank : winningRanks) {
            System.out.println(getPrintFormatHistory(winningMap, winningRank));
        }
    }

    private String getPrintFormatHistory(Map<WinningRank, Long> winningMap, WinningRank winningRank) {
        long matchCount = winningRank.getMatchCount();
        long reward = winningRank.getReward().getValue();
        Long winningCount = winningMap.getOrDefault(winningRank, 0l);
        String printItem = String.format(WINNING_HISTORY_PRINT_FORMAT, matchCount, reward, winningCount);
        return printItem;
    }

    private Map<WinningRank, Long> createWinningHistoryMap(WinningHistory winningHistory) {
        List<WinningRank> history = winningHistory.getHistory();
        return history.stream()
                .filter(winningRank -> !winningRank.equals(WinningRank.NO_RANK))
                .collect(groupingBy(winningRank -> winningRank, () -> new EnumMap<WinningRank, Long>(WinningRank.class), counting()));
    }

}
