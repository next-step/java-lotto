package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;

import java.util.List;

public class ResultView {
    private static final String LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String WINNING_CHANCE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String RANK1 = "6개 일치(2000000000)원 - %d개";
    private static final String RANK2 = "5개 일치(1500000)원 - %d개";
    private static final String RANK3 = "4개 일치(50000)원 - %d개";
    private static final String RANK4 = "3개 일치(5000)원 - %d개";
    private static final String PERCENTAGE = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoCount(int count) {
        System.out.println(String.format(LOTTO_COUNT, count));
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printChanceOfWinning(LottoCalculator lottoCalculator, int investment) {
        System.out.println(WINNING_CHANCE);
        System.out.println(LINE);
        System.out.println(String.format(RANK4, lottoCalculator.getRank4Count()));
        System.out.println(String.format(RANK3, lottoCalculator.getRank3Count()));
        System.out.println(String.format(RANK2, lottoCalculator.getRank2Count()));
        System.out.println(String.format(RANK1, lottoCalculator.getRank1Count()));
        System.out.println(String.format(PERCENTAGE, lottoCalculator.getWinningPercentage(investment)));
    }
}
