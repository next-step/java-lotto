package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoStatisticUtil;
import lotto.domain.Price;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String PRINT_STATISTIC = "당첨 통계\n---------";
    private static final String PRINT_PRIZE = "%s(%d원)- %d개";
    private static final String PRINT_YIELD = "총 수익률은 %.2f입니다.";

    public void printLottoCount(int count) {
        System.out.println(String.format(PRINT_LOTTO_COUNT, count));
    }

    public void printLotto(Lotto lotto) {
        String[] numbers = lotto.getLottoNumberList().stream().map(String::valueOf).toArray(String[]::new);
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public void printStatistic(Price totalPrice, Lotto winLotto, int bonusNumber, List<Lotto> lottoList) {
        System.out.println(PRINT_STATISTIC);

        Arrays.stream(Prize.generateInRank()).forEach(prize -> {
            System.out.println(String.format(PRINT_PRIZE, prize.getComment(), prize.getMoney(), LottoStatisticUtil.getPrizeCount(prize, winLotto, bonusNumber, lottoList)));
        });

        System.out.println(String.format(PRINT_YIELD, LottoStatisticUtil.getYield(totalPrice, winLotto, bonusNumber, lottoList)));
    }
}
