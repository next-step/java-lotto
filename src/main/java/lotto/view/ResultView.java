package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.LottoResults;

public class ResultView {
    private static final String PRINT_INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_BUY_LOTTO_COUNT = "%d개를 구매했습니다.\n";
    private static final String PRINT_LAST_WEEK_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_RANK_LIST = "%d개 일치 (%d원)- %d개\n";
    private static final String PRINT_SENCOND_RANK = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String PRINT_RATIO = "총 수익률은 %s입니다.\n";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static void printInputPrice() {
        System.out.println(PRINT_INPUT_PRICE);
    }

    public static void printLottoGames(LottoGame lottoGame) {
        int lottoCount = lottoGame.getLottos().size();
        printBuyLottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            printLottoNumbers(lottoGame.getLottos().get(i));
        }
        System.out.println();
    }

    private static void printBuyLottoCount(int count) {
        System.out.printf(PRINT_BUY_LOTTO_COUNT, count);
    }

    private static void printLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        String value = "[" + lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
        System.out.println(value);
    }

    public static void printLastWeekLotto() {
        System.out.println(PRINT_LAST_WEEK_LOTTO);
    }

    public static void printResults(LottoResults lottoResults) {
        for (LottoRank rank : LottoRank.values()) {
            printRank(rank, lottoResults);
        }
        System.out.println();
    }

    private static void printRank(LottoRank rank, LottoResults lottoResults) {
        if (rank != LottoRank.NONE && rank != LottoRank.SECOND) {
            System.out.printf(PRINT_RANK_LIST, rank.getMatchCount(), rank.getPrizeMoney(),
                    lottoResults.getPrizeCountByRank(rank));
        }
        if (rank == LottoRank.SECOND) {
            System.out.printf(PRINT_SENCOND_RANK, rank.getMatchCount(), rank.getPrizeMoney(),
                    lottoResults.getPrizeCountByRank(rank));
        }
    }

    public static void printRatio(String ratio) {
        System.out.printf(PRINT_RATIO, ratio);
    }

    public static void printInputBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);
    }
}
