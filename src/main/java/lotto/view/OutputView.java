package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.dto.LottoInput;
import lotto.vo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WINNING_HISTORY_PRINT_FORMAT = "%d개 일치 (%.0f원)- %d개";
    private static final String BUY_LOTTO_PRINT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매헀습니다.";
    private static final String YIELD_MORE_ONE_PRINT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String YIELD_LESS_ONE_PRINT_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void renderWithLottos(Lottos lottos, LottoInput lottoInput) {
        System.out.println(String.format(BUY_LOTTO_PRINT_FORMAT, lottoInput.getManualCount(), lottoInput.getAutoCount(Money.create(LottoRule.LOTTO_PRICE.getValue()))));
        printLottos(lottos);
    }

    private void printLottos(Lottos lottos) {
        lottos.getLottoList().stream()
                .forEach(lotto -> printLotto(lotto));
    }

    private void printLotto(Lotto lotto) {
        String collect = lotto.getLottoNumbers().stream()
                .map(num -> String.valueOf(num.getValue()))
                .collect(Collectors.joining(","));
        System.out.println("[" + collect + "]");
    }

    public void renderWithWinningHistory(WinningHistory winningHistory, List<WinningRank> winningRankList) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printHistory(winningHistory.getStat(), winningRankList);
        System.out.println(getPrintFormatWithYield(winningHistory));
    }

    private String getPrintFormatWithYield(WinningHistory winningHistory) {
        Double yield = winningHistory.getYield();
        if (yield < 0) {
            return String.format(YIELD_LESS_ONE_PRINT_FORMAT, yield);
        }
        return String.format(YIELD_MORE_ONE_PRINT_FORMAT, yield);
    }

    private void printHistory(WinningStatistics stat, List<WinningRank> winningRanks) {
        for (WinningRank winningRank : winningRanks) {
            System.out.println(getPrintFormatHistory(stat.getCount(winningRank), winningRank));
        }
    }

    private String getPrintFormatHistory(long winningCount, WinningRank winningRank) {
        long matchCount = winningRank.getMatchCount();
        BigDecimal reward = winningRank.getReward().getValue();
        String printItem = String.format(WINNING_HISTORY_PRINT_FORMAT, matchCount, reward, winningCount);
        return printItem;
    }

}
