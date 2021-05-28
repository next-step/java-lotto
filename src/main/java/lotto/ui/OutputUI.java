package lotto.ui;

import lotto.domains.Lotto;
import lotto.domains.Lottos;
import lotto.enums.MatchingInfo;

public class OutputUI {
    public static void printInputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfPurchases(int number) {
        System.out.println(number + "개를 구매했습니다.");
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
}
