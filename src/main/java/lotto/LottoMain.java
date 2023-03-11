package lotto;

import lotto.domain.WinningStatistics;
import lotto.domain.LottoGame;
import lotto.domain.LotteryNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(scanner.nextLine());

        LottoGame lottoGame = new LottoGame(buyMoney);
        System.out.println(lottoGame.getBuyCountForPrint() + "를 구매했습니다.");

        System.out.println(lottoGame.getAllLottoNumbersForPrint());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = scanner.nextLine();
        String[] splitWinningNumbers = inputWinningNumbers.replaceAll(" ", "").split(",");
        Set<Integer> winningNumbers = Arrays.stream(splitWinningNumbers).map(Integer::parseInt).collect(Collectors.toSet());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();

        LotteryNumbers lotteryNumbers = new LotteryNumbers(winningNumbers, bonusNumber);

        System.out.println("당첨 통계\n---------");

        WinningStatistics statistics = lottoGame.getStatistics(lotteryNumbers);

        System.out.println(statistics.printInformation());

        System.out.println("총 수익률은 " + statistics.getTotalRateOfReturn() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
