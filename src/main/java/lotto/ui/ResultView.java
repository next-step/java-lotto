package lotto.ui;

import lotto.domain.*;

import java.util.Arrays;

public class ResultView {
    private static final String PRINT_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String PRINT_STATISTIC = "당첨 통계\n---------";
    private static final String PRINT_PRIZE = "%s(%d원)- %d개";
    private static final String PRINT_YIELD = "총 수익률은 %.2f입니다.";

    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println(String.format(PRINT_LOTTO_COUNT, manualLottoCount, autoLottoCount));
    }

    public void printLotto(Lotto lotto) {
        String[] numbers = lotto.getLottoNumberList().stream().map(String::valueOf).toArray(String[]::new);
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public void printStatistic(Price totalPrice, Lotto winLotto, int bonusNumber, Lottos lottos) {
        System.out.println(PRINT_STATISTIC);

        Arrays.stream(Prize.generateInRank()).forEach(prize -> {
            System.out.println(String.format(PRINT_PRIZE, prize.getComment(), prize.getMoney(), LottoStatisticUtil.getPrizeCount(prize, winLotto, bonusNumber, lottos)));
        });

        System.out.println(String.format(PRINT_YIELD, LottoStatisticUtil.getYield(totalPrice, winLotto, bonusNumber, lottos)));
    }
}
