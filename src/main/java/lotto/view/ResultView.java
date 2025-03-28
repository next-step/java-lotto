package lotto.view;

import lotto.LottoNumber;
import lotto.LottoRank;

import java.util.Map;

import static lotto.LottoConfig.LOTTO_PRICE;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void printStat(int totalCount, Map<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", lottoRank.getMatchCount(), lottoRank.getMoney(), rankCount.getOrDefault(lottoRank, 0));
        }

        long winnings = rankCount.entrySet().stream()
                .mapToLong(entry -> (long)entry.getKey().getMoney() * entry.getValue())
                .sum();

        System.out.printf("총 수익률은 %.2f입니다.\n", (double)winnings / (totalCount * LOTTO_PRICE));
    }
}
