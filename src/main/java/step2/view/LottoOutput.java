package step2.view;

import static java.util.stream.Collectors.joining;

import java.util.stream.Collectors;
import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.LottoNumber;
import step2.model.LottoPrizes;
import step2.model.Lottos;

public class LottoOutput {

    private LottoOutput() {
    }

    private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
    private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PAY_OFF_FORMAT = "총 수익률은 %.2f입니다.(1기준으로 높으면 수익 낮으면 손해)\n";

    private static final String LOTTO_NUMBER_DELEVETER = ",";
    private static final String NEW_LINE = "\n";

    public static void printLottoNumbers(LottoGame lottoGame) {

        Lottos lottos = lottoGame.getLottos();

        String lottoNumbers = lottos.getLottos()
            .stream()
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

    public static void printPurchaseNumbers(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printWinningStatistics(LottoPrizes lottoPrizes) {
        System.out.printf(HEAD_FORMAT,
            lottoPrizes.getLottoPrizes()
                .stream()
                .map(prize -> String.format(BODY_FORMAT,
                    prize.getRank().getMatchCnt(),
                    prize.getRank().getPrice(),
                    prize.getCount()))
                .collect(joining(NEW_LINE))
        );

        System.out.printf(
            PAY_OFF_FORMAT,
            lottoPrizes.getPayOffRatio()
        );
    }
}