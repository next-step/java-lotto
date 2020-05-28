package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoStatisticUtil;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String PRINT_PRIZE = "%d개 일치 (%d원)- %d개";

    public void printLottoCount(int count) {
        System.out.println(String.format(PRINT_LOTTO_COUNT, count));
    }

    public void printLotto(Lotto lotto) {
        String[] numbers = lotto.getLottoNumberList().stream().map(value -> String.valueOf(value.getNumber())).toArray(String[]::new);
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public void printStatistic(Lotto winLotto, List<Lotto> lottoList) {
        Arrays.stream(Prize.generateInRank()).forEach(prize ->
            System.out.println(String.format(PRINT_PRIZE, prize.getNumber(), prize.getMoney(), LottoStatisticUtil.getPrizeCount(prize, winLotto, lottoList)))
        );
    }
}
