package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String ASK_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호를 잘못 입력 했습니다.";
    private static final String WINNING_COUNT_ERROR_MESSAGE = "당첨 번호 개수를 잘못 입력 했습니다.";
    private static final String MONEY_MINUNUM_ERROR_MESSAGE = "최소 1000원 이상 입력하세요.";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String WINNINGSTATISTICS = "\n당첨 통계";
    private static final String LINE = "---------";
    private static final String RESULT_INFO = "%s개 일치 (%s원)- %s개 \n";
    private static final String RESULT_SECOND_INFO = "%s개 일치, 보너스 볼 일치 (%s원)- %s개 \n";
    private static final String YEILD_MESSAGE = "총 수익률은 %f입니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호가 중복 됩니다.";

    public static void askManualLottosNumber() {
        System.out.println(ASK_MANUAL_LOTTO_NUMBERS);
    }

    public static void printLottosCount(int manualCount, int autoCount) {
        System.out.printf(PURCHASE_MESSAGE, manualCount, autoCount);
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

    public static void lottoNumberError() {
        System.out.println(LOTTO_NUMBER_ERROR_MESSAGE);
    }

    public static void winningNumberCountError() {
        System.out.println(WINNING_COUNT_ERROR_MESSAGE);
    }

    public static void printWinningStatistics(WinningStatistics statistics) {
        System.out.println(WINNINGSTATISTICS);
        System.out.println(LINE);

        List<Rank> sortRanks = Arrays.stream(Rank.values()).sorted().collect(Collectors.toList());

        for (Rank rank : sortRanks) {
            int count = statistics.rankCount(rank);
            printResult(rank, count);
        }

        printYeild(statistics);
    }

    private static void printResult(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.printf(RESULT_SECOND_INFO, rank.matchCount(), rank.price(), count);
            return;
        }
        System.out.printf(RESULT_INFO, rank.matchCount(), rank.price(), count);
    }


    private static void printYeild(WinningStatistics statistics) {
        System.out.printf(YEILD_MESSAGE, statistics.calcYeiild());
    }

    public static void printMoneyError() {
        System.out.println(MONEY_MINUNUM_ERROR_MESSAGE);
    }

    public static void bonusNumberError() {
        System.out.println(BONUS_NUMBER_ERROR_MESSAGE);
    }
}
