package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        System.out.println("구입금액을 입력해 주세요.");
        Scanner input = new Scanner(System.in);
        int price = Integer.parseInt(input.nextLine());
        lottoGame.buyLotto(price);
        System.out.println(lottoGame.countLotto() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.lottos()) {
            System.out.println(lotto.numbers());
        }
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String result = input.nextLine();
        List<Integer> list = Arrays.stream(result.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        lottoGame.registerWinningLotto(list);
        System.out.printf("당첨 통계%n-------%n");
        lottoGame.classifyRankLotto();
        WinningLottos winningLottos = lottoGame.winningLottos();
        for (Rank rank : Rank.values()) {
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.matchingCount(), rank.rewardPrice(), winningLottos.countLottoByWinningNumber(rank.matchingCount()));
        }
        System.out.printf("총 수익률은 %.2f입니다.", lottoGame.investingPercent(price));
    }
}
