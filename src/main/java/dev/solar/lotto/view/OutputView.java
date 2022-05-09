package dev.solar.lotto.view;

import java.util.Set;
import java.util.StringJoiner;

import dev.solar.lotto.LottoNumber;

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
}
