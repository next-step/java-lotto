package lotto.view;

import lotto.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Money lottoPrice = new Money(1000);

    public static void main(String[] args) {
        inputBudget();
    }

    public static void inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = scanner.nextInt();
        Money budget = new Money(input);
        long quantity = budget.purchase(lottoPrice);

        System.out.println(quantity + "개를 구매했습니다.");

        LottoGame lottoGame = new LottoGame(budget, lottoPrice);
        List<Lotto> lottos = lottoGame.getLottos();
        lottos.forEach(System.out::println);

        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String next = scanner.next();
        Lotto winningLotto = getWinningLotto(next);

        RankMap countByRank = lottoGame.getPrizeByRank(winningLotto);
        StatisticView statisticView = new StatisticView();
        statisticView.viewWinningLottos(countByRank);

        Prizes prizes = countByRank.getAllPrizes();
        Money sum = prizes.sum();
        Ratio ratio = sum.calculateRatio(budget);
        System.out.println(String.format("총 수익률은 %s입니다.", ratio));
    }

    private static Lotto getWinningLotto(String next) {
        return new Lotto(
                Arrays.stream(next.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet())
        );
    }
}