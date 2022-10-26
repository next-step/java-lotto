package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;

public class Output {
    private Output() {
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printManuallyLottoNumberRequest(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }


    public static void printPurchasedLotto(Lottos lottos) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", lottos.getAutoQuantity(), lottos.getManualQuantity());
        printLotto(lottos.getLottos());
    }

    private static void printLotto(List<Lotto> numbers) {
        for (Lotto number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    public static void printWinnerNumbersRequest() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", result.numberOfFifthRank());
        System.out.printf("4개 일치 (50000원)- %d개\n", result.numberOfFourthRank());
        System.out.printf("5개 일치 (1500000원)- %d개\n", result.numberOfThirdRank());
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개\n", result.numberOfSecondRank());
        System.out.printf("6개 일치 (2000000000원)- %d개\n", result.numberOfFirstRank());
        if (result.hasBenefit()) {
            System.out.printf("총 수익률은 %.2f입니다.(어떻게 하셧죠??????)", result.calculateProfitRate());
            return;
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.calculateProfitRate());
    }
}
