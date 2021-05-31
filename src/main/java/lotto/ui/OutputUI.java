package lotto.ui;

import lotto.domains.Lotto;
import lotto.domains.Lottos;
import lotto.enums.MatchingInfo;
import lotto.enums.PurchasingWay;

public class OutputUI {
    public static void printInputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfPurchases(Lottos lottos) {
        int automaticCount = lottos.countOfPurchasingWay(PurchasingWay.AUTOMATIC);
        int manualCount = lottos.countOfPurchasingWay(PurchasingWay.MANUAL);
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualCount, automaticCount);
        System.out.println();
    }

    public static void printInputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printRateOfReturn(Lottos lottos) {
        System.out.printf("총 수익률은 %s 입니다.", String.format("%.2f", lottos.rateOfReturn()));
    }

    public static void printLottosNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.lottoNumbers().lottoNumbers().toString());
        }
    }

    public static void printInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printStatistics(Lottos lottos) {
        for (MatchingInfo matchingInfo : MatchingInfo.values()) {
            System.out.printf("%d개 일치 %s (%d원)- %d개",
                    matchingInfo.matchingNumber(),
                    matchingInfo.hasBonusNumber() ? ", 보너스 볼 일치" : "",
                    matchingInfo.getPayout(),
                    lottos.countOfMatchingNumber(matchingInfo));
            System.out.println();
        }
    }

    public static void printInputManualLottoAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printInputManualLottosNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
