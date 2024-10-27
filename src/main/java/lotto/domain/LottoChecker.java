package lotto.domain;

import java.util.List;

public class LottoChecker {

    private final List<Lotto> purchasedLottos;
    private final Lotto winnerLotto;

    public LottoChecker(List<Lotto> purchasedLottos, Lotto winnerLotto) {
        winnerLottoEmptyCheck(winnerLotto);

        this.purchasedLottos = purchasedLottos;
        this.winnerLotto = winnerLotto;
    }

    private void winnerLottoEmptyCheck(Lotto winnerLotto) {
        if (winnerLotto == null)
            throw new IllegalArgumentException("우승 번호가 없습니다.");
    }

    public Boolean containsWinnerNumbers(List<Integer> numbers) {
        return winnerLotto.containsNumbers(numbers);
    }
}
