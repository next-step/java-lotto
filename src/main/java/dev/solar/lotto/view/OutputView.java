package dev.solar.lotto.view;

import java.util.NavigableSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;

import dev.solar.lotto.LottoNumber;
import dev.solar.lotto.PrizeMoney;

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

    public static void printResult(TreeMap<PrizeMoney, Integer> winningResult) {
        final NavigableSet<PrizeMoney> prizeMonies = winningResult.navigableKeySet();
        prizeMonies
                .forEach(prizeMoney -> System.out.printf("%d개 일치 (%d원) - %d 개 %n", prizeMoney.getCount(), prizeMoney.getPrizeMoney(), winningResult.get(prizeMoney)));
    }
}
