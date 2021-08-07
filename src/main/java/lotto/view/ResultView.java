package lotto.view;

import lotto.Lotto;
import lotto.LottoMachine;
import lotto.SameNumbersCount;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계\n";
    private static final String LINE = "-------\n";

    public void printLotties(LottoMachine lottoMachine) {
        System.out.printf(PURCHASE_MESSAGE, lottoMachine.getLottoCount());

        for (int i = 0; i < lottoMachine.lottiesCount(); i++) {
            Lotto lotto = lottoMachine.getLotties().getLotties().get(i);
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    public void printSameNumbers() {
        System.out.print(WINNING_STATISTICS);
        System.out.print(LINE);

        for (SameNumbersCount s : SameNumbersCount.values()) {
            System.out.printf("%d개 일치 (%d원)- ", s.getSameNumbersCount(), s.getPrizeMoney());
            System.out.printf("%d개", s.getCount());
            System.out.println();

        }
    }
}
