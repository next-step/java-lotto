package lotto.ui;

import lotto.domain.Amount;
import lotto.domain.Lotto;

import java.util.List;

public class LottoOutput {

    public static void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void manualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void purchaseCount(final Amount manual, final Amount auto) {
        System.out.println(String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.", manual, auto));
    }

    public static void lotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void lotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void statistics() {
        StringBuilder result = new StringBuilder();
        result.append("당첨 통계");
        result.append("---------");
        System.out.println(result);
    }

    public static void match(int count, int reward, int number) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개", count, reward, number));
    }

    public static void matchBonusNumber(int count, int reward, int number) {
        System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", count, reward, number));
    }

    public static void yield(double yield) {
        if (yield < 1) {
            System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield));
        } else {
            System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)", yield));
        }
    }
}
