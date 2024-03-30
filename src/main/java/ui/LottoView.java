package ui;

import lotto.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LottoView {

    public void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + getJoinedString(lotto) + "]");
        }
    }

    public void printLottoSummary(LottoSummary summary) {
        Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.NONE)
            .sorted(Comparator.reverseOrder())
            .forEach(rank -> {
                System.out.println(RankSentenceProvider.sentence(rank, summary.getRankCount(rank)));
            });
        System.out.println(String.format("총 수익률은 %.2f입니다", summary.rateOfReturn()));
    }

    public void printBoughtLottoCount(int manualLottoCount, int total) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, (total -= manualLottoCount)));
    }

    private String getJoinedString(Lotto lotto) {
        return lotto.getNumbers().getNumbers().stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
