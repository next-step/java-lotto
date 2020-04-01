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

        List<Lotto> lottos = lottoGame.createLottos(purchaseCount);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();

        List<Integer> winningNumbers = Arrays.stream(value.split(","))
                .map(Integer::new)
                .collect(toList());

        Lotto winningLotto = new Lotto(winningNumbers);

        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = lottoGame.match(lotto, winningLotto);
            results.add(lottoGame.getRank(matchCount));
        }

        int totalWinnings = lottoGame.getTotalWinnings(results);

        double rateOfRevenue = lottoGame.getRateOfRevenue(price, totalWinnings);

        System.out.println(String.format("총 수익률은 %f입니다", rateOfRevenue));
    }
}
