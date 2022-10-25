package lotto.ui;

import lotto.models.IssuedLotto;
import lotto.models.LottoStatistics;
import lotto.models.enums.IssueType;
import lotto.models.enums.Rank;
import lotto.models.request.IssueLottoRequest;
import lotto.models.request.WinningLottoRequest;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    public static IssueLottoRequest requestIssueLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        String payment = InputScanner.stringScan();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(InputScanner.stringScan());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        while (manualLottoCount-- > 0) {
            String number = InputScanner.stringScan();
            manualLottoNumbers.add(number);
        }

        return IssueLottoRequest.of(Integer.parseInt(payment), manualLottoNumbers);
    }

    public static void printLottoNumbers(List<IssuedLotto> lottos) {
        long manualCount = lottos.stream().filter(lotto -> lotto.getIssueType().equals(IssueType.manual)).count();
        long randomCount = lottos.stream().filter(lotto -> lotto.getIssueType().equals(IssueType.random)).count();

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, randomCount);
        lottos.forEach(lotto -> System.out.println(lotto.getLotto().getNumbers().toString()));
    }

    public static WinningLottoRequest requestWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = InputScanner.stringScan();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = InputScanner.intScan();

        return WinningLottoRequest.of(winningNumbers, bonusNumber);
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
}
