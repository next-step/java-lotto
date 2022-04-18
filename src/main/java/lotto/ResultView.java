package lotto;

import java.util.Collections;
import java.util.List;

public class ResultView {

    public void printPurchaseLottoList(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");

        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getLottoNumbers());
        }
    }

    public void printLottoRank(List<Rank> ranks) {
        for (Rank rank : Rank.values()) {
            int frequency = Collections.frequency(ranks, rank);
            printEachRank(rank, frequency);
        }
    }

    private void printEachRank(Rank rank, int frequency) {
        StringBuilder sb = new StringBuilder();

        sb.append(rank.getMatchCount())
                .append("개 일치 = ")
                .append(rank.getWinnings())
                .append("원 - ")
                .append(frequency)
                .append("개");

        System.out.println(sb);
    }

    public void printTotalRate(double rate) {
        System.out.println("총 수익률은 " + rate + " 입니다.");
    }
}
