package lotto.ui;

import lotto.domain.Lotto;

public class LottoOutput {

    public static void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseCount(int number) {
        System.out.println(String.format("%d개를 구매했습니다.", number));
    }

    public static void lotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void statistics() {
        StringBuilder result = new StringBuilder();
        result.append("당첨 통계");
        result.append("---------");
        System.out.println(result);
    }

    public static void match3(int number) {
        System.out.println(String.format("3개 일치 (5000원)- %d개", number));
    }

    public static void match4(int number) {
        System.out.println(String.format("4개 일치 (50000원)- %d개", number));
    }

    public static void match5(int number) {
        System.out.println(String.format("5개 일치 (1500000원)- %d개", number));
    }

    public static void match6(int number) {
        System.out.println(String.format("6개 일치 (2000000000원)- %d개", number));
    }

    public static void yield(int yield) {
        if (yield < 1) {
            System.out.println(String.format("총 수익률은 %d입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield));
        } else {
            System.out.println(String.format("총 수익률은 %d입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)", yield));
        }
    }
}
