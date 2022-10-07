package lotto.ui;

import lotto.models.Lotto;

import java.util.List;

public class Printer {

    public static String requestPayment() {
        System.out.println("구매금액을 입력해 주세요.");
        return InputScanner.stringScan();
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers().toString());
        });
    }

    public static String requestWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return InputScanner.stringScan();
    }

}
