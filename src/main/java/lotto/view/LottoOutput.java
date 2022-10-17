package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoMatchCount;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.ProfitRate;
import lotto.domain.lotto.Lotto;

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
        System.out.println("수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.");
    }

    public static void lotto(final Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void lotto(final List<Lotto> lottoList) {
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

    public static void match(final LottoMatchCount count, final ImmutableMoney reward, final Amount number) {
        System.out.println(count + "개 일치 (" + reward + "원)- " + number + "개");
    }

    public static void matchBonusNumber(final LottoMatchCount count, final ImmutableMoney reward, final Amount number) {
        System.out.println(count + "개 일치, 보너스 볼 일치(" + reward + "원) - " + number + "개");
    }

    public static void profitRate(final ProfitRate profitRate) {
        if (profitRate.loss()) {
            System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        } else {
            System.out.println("총 수익률은 " + profitRate + "f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
        }
    }
}
