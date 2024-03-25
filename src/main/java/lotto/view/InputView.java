package lotto.view;

import lotto.*;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Money lottoPrice = new Money(1000);

    public static void main(String[] args) {
        inputBudget();
    }

    public static void inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        int budgetInput = scanner.nextInt();
        Money budget = new Money(budgetInput);
        PurchaseLimit purchaseLimit = new PurchaseLimit(budget, lottoPrice);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        long manual = scanner.nextLong();
        ManualCount manualCount = new ManualCount(manual, purchaseLimit);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] manualNumbers = inputManualNumbers(manual);

        ManualLottos manualLottos = new ManualLottos(manualNumbers);
        AutoCount autoCount = purchaseLimit.decrease(manualCount);
        AutoLottos autoLottos = new AutoLottos(autoCount);

        System.out.println(String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.", manualCount, autoCount));
        LottoGame lottoGame = autoLottos.merge(manualLottos);

        List<Lotto> lottos = lottoGame.getLottos();
        lottos.forEach(System.out::println);

        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String next = scanner.next();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scanner.nextInt();
        WiningLotto winningLotto = new WiningLotto(next, bonus);

        RankMap countByRank = lottoGame.getPrizeByRank(winningLotto);
        StatisticView statisticView = new StatisticView();
        statisticView.viewWinningLottos(countByRank);

        Prizes prizes = countByRank.getAllPrizes();
        Money sum = prizes.sum();
        Ratio ratio = sum.calculateRatio(budget);
        System.out.println(String.format("총 수익률은 %s입니다.", ratio));
    }

    private static String[] inputManualNumbers(long manual) {
        Set<String> manualNumbers = new HashSet<>();
        for (int i = 0; i < manual; i++) {
            manualNumbers.add(scanner.next());
        }
        return (String[]) manualNumbers.toArray();
    }
}