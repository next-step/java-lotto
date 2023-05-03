package lottery;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LotteryCalculatorConsoleView implements LotteryCalculatorView {
    private static final Integer MIN_WIN_NUM_MATCHES = 3;
    private static final Integer LOTTERY_NUM_NUMBERS = 6;
    private static final List<Integer> REWARD_AMOUNT_FOR_NUM_MATCHES = List.of(0, 0, 0, 5000, 50000, 1500000, 2000000000);
    public static final Map<PnLType, String> pnLMessage = Map.of(
            PnLType.LOSS, "기준이 1이기 때문에 결과적으로 손해라는 의미임",
            PnLType.EVEN, "기준이 1이기 때문에 결과적으로 본전이라는 의미임",
            PnLType.PROFIT, "기준이 1이기 때문에 결과적으로 이득이라는 의미임"
    );

    Scanner scanner = new Scanner(System.in);

    @Override
    public List<Integer> getNumbersToCompare() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        var input = scanner.nextLine();
        return commaSplicedNumbersToIntegerList(input);
    }

    public List<Integer> commaSplicedNumbersToIntegerList(String commaSplicedNumbers) {
        return Arrays.stream(commaSplicedNumbers.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public void showResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    @Override
    public void showLotteryCountForNumMatches(List<Integer> lotteryCountForNumMatches) {
        for (var numMatches = MIN_WIN_NUM_MATCHES; numMatches < LOTTERY_NUM_NUMBERS; numMatches++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", numMatches, REWARD_AMOUNT_FOR_NUM_MATCHES.get(numMatches), lotteryCountForNumMatches.get(numMatches));
        }
    }

    @Override
    public void showPnL(PnLResult pnLResult) {
        System.out.printf("총 수익률은 %.2f입니다.(%s)", pnLResult.ror, pnLMessage.get(pnLResult.pnLType));
    }
}
