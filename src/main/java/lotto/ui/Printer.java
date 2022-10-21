package lotto.ui;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.enums.Rank;
import lotto.models.request.LottoNumberRequest;
import lotto.models.request.PaymentRequest;
import lotto.models.request.WinningLottoRequest;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    public static PaymentRequest requestPayment() {
        System.out.println("구매금액을 입력해 주세요.");
        String payment = InputScanner.stringScan();
        return PaymentRequest.of(Integer.parseInt(payment));
    }

    public static void printLottoNumbers(List<Lotto> lottos, int manualLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoCount, lottos.size() - manualLottoCount);
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers().toString());
        });
    }

    public static WinningLottoRequest requestWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = InputScanner.stringScan();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = InputScanner.intScan();

        return WinningLottoRequest.of(LottoNumberRequest.of(winningNumbers), bonusNumber);
    }

    public static void printStatistics(List<LottoStatistics> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        lottoStatistics.stream()
                .filter(statistics -> !statistics.getRank().equals(Rank.OTHER))
                .forEach(statistics -> {
                    if (statistics.getRank().equals(Rank.OTHER)) {
                        return;
                    }

                    String statisticsText = "%d개 일치 (\"%d원\")- %d개%n";
                    if (statistics.getRank().equals(Rank.SECOND)) {
                        statisticsText = "%d개 일치, 보너스 볼 일치 (\"%d원\")- %d개%n";
                    }

                    System.out.printf(statisticsText,
                            statistics.getRank().getEqualCount(),
                            statistics.getRank().getAmount(),
                            statistics.getCount());
                });
    }

    public static void printRevenueRatio(float revenueRatio) {
        String description = String.format("총 수익률은 %.2f입니다.", revenueRatio);
        if (revenueRatio < 1) {
            description = description.concat("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(description);
    }

    public static List<LottoNumberRequest> requestManualNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(InputScanner.stringScan());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumberRequest> lottoNumberRequests = new ArrayList<>();
        while (manualLottoCount-- > 0) {
            String number = InputScanner.stringScan();
            lottoNumberRequests.add(LottoNumberRequest.of(number));
        }

        return lottoNumberRequests;
    }

}
