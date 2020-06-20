package step2.view;

import step2.model.*;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class LottoOutput {

    private LottoOutput() { };

    private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
    private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PAY_OFF_FORMAT = "총 수익률은 %.2f입니다.\n";

    private static final String LOTTO_NUMBER_DELEVETER = ",";
    private static final String NEW_LINE = "\n";

    public static void printLottoNumbers(LottoGame lottoGame) {

        Lottos lottos = lottoGame.getLottos();

        String lottoNumbers = lottos.stream()
                .map(LottoOutput::lottoToString)
                .map(i -> i.toString())
                .collect(Collectors.joining(NEW_LINE));

        System.out.printf("%s\n", lottoNumbers);
    }

    public static String lottoToString(Lotto lotto) {
        String str = lotto.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(joining(LOTTO_NUMBER_DELEVETER));
        return "[" + str + "]";
    }

    public static void printPurchaseNumbers(int lottoCount, int selfLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",selfLottoCount, lottoCount);
    }

    public static void printWinningStatistics(LottoTotalCalculator lottoTotalCalculator) {
        System.out.printf(HEAD_FORMAT,
                lottoTotalCalculator.stream()
                        .map(prize -> String.format(BODY_FORMAT,
                                prize.getRank().getMatchCnt(),
                                prize.getRank().getPrice(),
                                prize.getCount()))
                        .collect(joining(NEW_LINE))
        );

        System.out.printf(
                PAY_OFF_FORMAT,
                lottoTotalCalculator.resultLottoGamePayOffRatio()
        );
    }
}
