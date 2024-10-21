package lotto.view;

import lotto.constants.LottoRank;
import lotto.domain.Lotto;

import java.util.*;

public class LottoPrint {

    private final String ENTER = "\n";
    private StringBuilder stringBuilder = new StringBuilder();

    public void lottoPurchasedCount(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
    }

    public void lottoResult(Map<String, Integer> rankCounts, double profitRate) {
        stringBuilder.setLength(0);
        stringBuilder
                .append(ENTER)
                .append("당첨통계")
                .append(ENTER)
                .append("----------")
                .append(ENTER);

        generateResult(rankCounts);
        profitRateResult(profitRate);

        System.out.println(stringBuilder);
    }

    private void generateResult(Map<String, Integer> rankCounts) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getCount() >= 3)
                .sorted(Comparator.comparingInt(LottoRank::getCount))
                .forEach(rank -> stringBuilder.append(rank.getCount())
                        .append("개 일치 (")
                        .append(rank.getAmount())
                        .append("원)- ")
                        .append(rankCounts.get(rank.getRank()))
                        .append("개")
                        .append(ENTER));

    }

    private void profitRateResult(double profitRate) {
        stringBuilder.append("총 수익률은 ")
                .append(String.format("%.2f", profitRate))
                .append("입니다.");

    }

}
