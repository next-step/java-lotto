package step4;

import java.util.*;
import java.util.stream.Stream;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto() {
    }

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public static List<LottoNumber> valueOf(Lotto lotto) {
        return lotto.lotto;
    }

    public static List<LottoNumber> lotteryStatics(Set<Lotto> purchasedLottos, Lotto winningNumbers) {
        List<LottoNumber> resultMatching = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            int add = 0;
            add = +matchWinningNumbers(Lotto.valueOf(purchasedLotto), Lotto.valueOf(winningNumbers));
            resultMatching.add(new LottoNumber(add, false));
        }
        return resultMatching;
    }

    private static int matchWinningNumbers(List<LottoNumber> purchasedLotto, List<LottoNumber> winningNumbers) {
        Iterator<LottoNumber> iter = purchasedLotto.iterator();
        int count = 0;
        while (iter.hasNext()) {
            LottoNumber compareNumber = iter.next();
            count += (int) winningNumbers.stream()
                    .filter(x -> x.equals(compareNumber))
                    .count();
        }
        return count;
    }

    public static void pickOutBonusWinningLotto(Set<Lotto> purchasedLottos) {
        int indexCount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoLottery.purchasedLottoCompareBonusNumber(purchasedLotto.lotto, indexCount);
            indexCount++;
        }
    }

    public static <T> Set<T> mergeLottoSets(Set<T> manualLottos, Set<T> autoLottos) {
        Set<T> set = new LinkedHashSet<>();
        Stream.of(manualLottos, autoLottos).forEach(set::addAll);
        return set;
    }
}