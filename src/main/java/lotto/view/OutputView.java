package lotto.view;

import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public static void lottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void lottoView(Lotto lotto) {
        LottoNumbers lottoNumbers = lotto.getLottoNumbers();

        System.out.println(
            lottoNumbers.getValues().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX))
        );
    }

    public static void staticsView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void matchView(Rank rank, int count) {
        System.out.println(rank.getMessage() + count + "개");
    }

    public static void ratioView(double ratio) {
        if (ratio < 1) {
            System.out.println("총 수익률은 " + ratio + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        if (ratio > 1) {
            System.out.println("총 수익률은 " + ratio + "입니다.");
        }
    }
}
