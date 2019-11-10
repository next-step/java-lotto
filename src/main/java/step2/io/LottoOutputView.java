package step2.io;

import java.io.PrintStream;
import java.util.stream.Collectors;

import step2.domain.Lotto;
import step2.domain.LottoMatch;
import step2.domain.LottoResult;
import step2.domain.Lottos;

public class LottoOutputView {
    private static final PrintStream out = System.out;

    public static void printResult(final LottoResult lottoResult) {
        out.println();
        out.println("당첨 통계");
        out.println("---------");

        LottoMatch.all()
                  .forEach(lottoMatch -> out.println(format(lottoMatch, lottoResult)));

        printRate(lottoResult);
    }

    private static String format(final LottoMatch lottoMatch, final LottoResult lottoResult) {
        return String.format("%s개 일치 (%s원)- %s개",
                             lottoMatch,
                             lottoMatch.winningReward(),
                             lottoResult.count(lottoMatch));
    }

    public static void println(final String message) {
        out.println(message);
    }

    public static void printBuyResult(final Lottos lottos) {
        out.println();
        out.println(String.format("%s개를 구매했습니다.", lottos.size()));
        out.println(toStringLottos(lottos));
        out.println();
    }

    private static String toStringLottos(final Lottos lottos) {
        return lottos.getLottos().stream()
                     .map(Lotto::toString)
                     .collect(Collectors.joining("\n"));
    }

    private static void printRate(final LottoResult lottoResult) {
        out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s의 의미임)",
                                  lottoResult.winningRate(),
                                  getMessage(lottoResult.winningRate())));
    }

    private static String getMessage(final double rate) {
        if (rate < 1) {
            return "손해";
        }
        if (rate > 1) {
            return "이익";
        }
        return "본전";
    }
}
