package dev.solar.lotto.view;

import java.util.NavigableSet;
import java.util.Set;
import java.util.StringJoiner;

import dev.solar.lotto.domain.Lotto;
import dev.solar.lotto.domain.LottoNumber;
import dev.solar.lotto.domain.PrizeMoney;
import dev.solar.lotto.domain.Rank;

public class OutputView {
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";

    public static void printLotto(Set<LottoNumber> lottoNumbers) {
        final StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        lottoNumbers.forEach(
                number -> stringJoiner.add(String.valueOf(number.getValue()))
        );
        System.out.println(stringJoiner);
    }

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + "개 구매했습니다.");
    }

    public static void printResult(Rank rank) {
        System.out.println("당첨 통계 \n==============");
        final NavigableSet<PrizeMoney> prizeMonies = rank.getNavigableKeySet();
        prizeMonies
                .forEach(prizeMoney -> System.out.printf("%d개 일치 (%d원) - %d 개 %n", prizeMoney.getCount(), prizeMoney.getPrizeMoney(), rank.getValue(prizeMoney)));
    }

    public static void printProfitMargin(final Lotto lotto, final Rank rank) {
        final double profitMargin = lotto.calculateProfitMargin(rank);
        System.out.printf("총 수익률은 %.2f 입니다.", profitMargin);
    }
}
