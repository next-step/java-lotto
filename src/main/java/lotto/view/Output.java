package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String PURCHASE_MESSAGE = "%s 개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호를 잘못 입력 했습니다.";
    private static final String WINNING_COUNT_ERROR_MESSAGE = "당첨 번호 개수를 잘못 입력 했습니다.";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String WINNINGSTATISTICS = "\n당첨 통계";
    private static final String LINE = "---------";
    private static final String RESULT_INFO = "\"%s개 일치 (%s원)- %s개\\n\"";


    public static void printLottosCount(Lottos lottos) {
        int lottoCount = lottos.lottoCount();
        System.out.printf(PURCHASE_MESSAGE, lottoCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();

        lottoList.forEach(Output::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));

        System.out.println(collect);
    }

    public static void LottoNumberError() {
        System.out.println(LOTTO_NUMBER_ERROR_MESSAGE);
    }

    public static void WinningNumberCountError() {
        System.out.println(WINNING_COUNT_ERROR_MESSAGE);
    }

    public static void printWinningStatistics(WinningStatistics statistics) {
        System.out.println(WINNINGSTATISTICS);
        System.out.println(LINE);
        for (Rank rank : Rank.values()) {
            int count = statistics.rankCount(rank);
            if (rank.matchCount() > 2) {
                System.out.printf(RESULT_INFO, rank.matchCount(), rank.price(), count);
            }
        }
    }
}
