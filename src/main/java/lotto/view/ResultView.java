package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.type.RankType;

import java.util.List;

public class ResultView {
    private static final String LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_CHANCE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String RANK1 = "6개 일치(2000000000)원 - %d개";
    private static final String RANK2 = "5개 일치, 보너스 볼 일치(30000000원) - %d개";
    private static final String RANK3 = "5개 일치(1500000)원 - %d개";
    private static final String RANK4 = "4개 일치(50000)원 - %d개";
    private static final String RANK5 = "3개 일치(5000)원 - %d개";
    private static final String PERCENTAGE = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoCount(int manualCount, int autoCount) {
        System.out.println(String.format(LOTTO_COUNT, manualCount, autoCount));
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printChanceOfWinning(LottoCalculator lottoCalculator, int investment) {
        System.out.println(WINNING_CHANCE);
        System.out.println(LINE);
        System.out.println(String.format(RANK5, lottoCalculator.getCount(RankType.RANK5)));
        System.out.println(String.format(RANK4, lottoCalculator.getCount(RankType.RANK4)));
        System.out.println(String.format(RANK3, lottoCalculator.getCount(RankType.RANK3)));
        System.out.println(String.format(RANK2, lottoCalculator.getCount(RankType.RANK2)));
        System.out.println(String.format(RANK1, lottoCalculator.getCount(RankType.RANK1)));
        System.out.println(String.format(PERCENTAGE, lottoCalculator.getWinningPercentage(investment)));
    }
}
