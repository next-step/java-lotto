package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class LottoGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");
        int price = scanner.nextInt();

        scanner.nextLine();

        LottoGame lottoGame = new LottoGame();
        int purchaseCount = lottoGame.purchaseLotto(price);

        System.out.println(String.format("%d개를 구매했습니다.", purchaseCount));

        List<Lotto> lottos = lottoGame.createLottos(purchaseCount);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();

        List<Integer> winningNumbers = Arrays.stream(value.split(","))
                .map(Integer::new)
                .collect(toList());

        Lotto winningLotto = new Lotto(winningNumbers);

        List<Rank> results = new ArrayList<>();

        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Lotto lotto : lottos) {
            int matchCount = lottoGame.match(lotto, winningLotto);
            results.add(lottoGame.getRank(matchCount));
        }

        System.out.println("3개 일치 (5000원) - " + results.stream().filter(r -> r == Rank.FOURTH).count());
        System.out.println("4개 일치 (50000원) - " + results.stream().filter(r -> r == Rank.THIRD).count());
        System.out.println("5개 일치 (1500000원) - " + results.stream().filter(r -> r == Rank.SECOND).count());
        System.out.println("6개 일치 (2000000000원) - " + results.stream().filter(r -> r == Rank.FIRST).count());

        int totalWinnings = lottoGame.getTotalWinnings(results);

        double rateOfRevenue = lottoGame.getRateOfRevenue(price, totalWinnings);

        System.out.println(String.format(
                "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)",
                rateOfRevenue
        ));
    }
}
