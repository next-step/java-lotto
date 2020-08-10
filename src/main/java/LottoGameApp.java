import domain.LottoGame;
import domain.LottoGames;
import domain.LottoMoney;
import domain.LottoWinningNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        LottoMoney lottoMoney = new LottoMoney(money);
        List<LottoGame> lottoGameList = lottoMoney.generateLottoGame();
        LottoGames lottoGames = new LottoGames(lottoGameList);

        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningNumberStr = scanner.nextLine();
        List<Integer> winningNumberList = Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumberList);

        for (LottoGame lottoGame : lottoGameList) {
            System.out.println(lottoGame.getNumbers());
        }

        Map<Integer, Integer> winningStatistics = lottoGames.getWinningStatistics(lottoWinningNumbers);
        double benefitRate = lottoGames.getBenefitRate(winningStatistics, lottoMoney);

        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, LottoGames.winningMoneyMap.get(i), winningStatistics.get(i));
        }

        System.out.println("=========");
        System.out.printf("수익률 : %f\n", benefitRate);
    }
}
