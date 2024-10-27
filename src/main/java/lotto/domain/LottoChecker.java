package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoChecker {

    private final int[] matchCounts;
    private final List<Lotto> purchasedLottos;
    private final Lotto winNumberLotto;

    public LottoChecker(List<Lotto> purchasedLottos, Lotto winNumberLotto) {
        winnerLottoEmptyCheck(winNumberLotto);

        this.purchasedLottos = purchasedLottos != null ? purchasedLottos : new ArrayList<>();
        this.winNumberLotto = winNumberLotto;
        int[] matchCounts = new int[7];

        for (Lotto lotto : this.purchasedLottos) {
            matchCounts[countMatch(lotto)]++;
        }

        this.matchCounts = matchCounts;
    }

    private int countMatch(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += countMatchNumber(lotto.getNumberByIndex(i));
        }
        return count;
    }

    private void winnerLottoEmptyCheck(Lotto winnerLotto) {
        if (winnerLotto == null)
            throw new IllegalArgumentException("우승 번호가 없습니다.");
    }

    public Boolean containsWinNumbers(List<Integer> numbers) {
        return winNumberLotto.containsNumbers(numbers);
    }

    public Integer countMatchNumber(Integer number) {
        if (containsWinNumbers(Arrays.asList(number)))
            return 1;
        return 0;
    }

    public Integer getWinnerCount(int index) {
        return this.matchCounts[index];
    }

    public Integer getPurchaseCount() {
        return this.purchasedLottos.size();
    }

}
