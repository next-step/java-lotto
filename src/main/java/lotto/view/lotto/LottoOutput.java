package lotto.view.lotto;

import java.util.List;

public class LottoOutput {

    public static void purchaseManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void purchaseManualAmountInputException() {
        System.out.println("수동으로 구매할 로또 수 입력이 잘못됐습니다 다시 입력해주세요.");
    }

    public static void manualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void lottoNumbersInputException() {
        System.out.println("로또 번호 입력이 잘못됐습니다 다시 입력해주세요.");
    }

    public static void purchaseCount(final int manual, final int auto) {
        System.out.println("수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.");
    }

    public static void lotto(final List<String> lottoList) {
        for (String lotto : lottoList) {
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

    public static void match(final String rank, final int number) {
        System.out.println(rank + "개 일치 (" + rank + "원)- " + number + "개");
    }

    public static void matchBonusNumber(final String rank, final int number) {
        System.out.println(rank + "개 일치, 보너스 볼 일치(" + rank + "원) - " + number + "개");
    }

    public static void profitRateLoss(final String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void profitRateBenefit(final String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
    }

    public static void bonusNumberInputException() {
        System.out.println("보너스 번호 입력이 잘못됐습니다 다시 입력해주세요.");
    }
}
