package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public static List<Integer> lotteryStatics(Set<Lotto> purchasedLottos, List<Integer> winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            resultMatching.add(matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    private static int matchWinningNumbers(Lotto purchasedLotto, List<Integer> winningNumbers) {
        final int count = (int) winningNumbers.stream()
                .filter(purchasedLotto.lotto::contains)
                .count();
        return count;
    }

    public static void pickOutBonusWinningLotto(Set<Lotto> purchasedLottos) {
        int indexCount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoLottery.purchasedLottoCompareBonusNumber(purchasedLotto.lotto, indexCount);
            indexCount++;
        }
    }

    public static void goPrint(Set<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            ResultView.printPurchasedLottos(purchasedLotto.lotto);
        }
        System.out.println();
    }
}