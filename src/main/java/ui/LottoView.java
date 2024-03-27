package ui;

import lotto.Lotto;
import lotto.LottoSummary;
import lotto.Lottos;
import lotto.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LottoView {

    public void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + getJoinedString(lotto) + "]");
        }
    }

    private String getJoinedString(Lotto lotto) {
        return lotto.getNumbers().getNumbers().stream().map(String::valueOf).collect(Collectors.joining(","));
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
}
