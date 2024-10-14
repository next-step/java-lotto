package lotto.ui;

import lotto.domain.LotteryMachine;

public class ResultView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    private ResultView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static void printLottoInfo(LotteryMachine machine) {
        printPurchasedLottoCount(machine);
        printLotto(machine);
    }

    private static void printPurchasedLottoCount(LotteryMachine machine) {
        System.out.printf((PURCHASED_LOTTO_COUNT_MESSAGE) + "%n", machine.getPurchasedLottoCount());
    }

    private static void printLotto(LotteryMachine machine) {
        machine.getLottoNumbers()
                .forEach(numbers -> System.out.printf("[%s]%n", numbers));
    }
}
