package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";
    private static final int LOTTO_AMOUNT = 1000;
    public static final String INVALID_LOTTO_COUNT_MSG = "로또 번호는 6개 여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_MSG = "보너스번호는 중복될 수 없습니다.";

    private List<Lotto> lottos;

    public Lottos(final Amount purchaseAmount) {
        this.lottos = initLottos(purchaseAmount);
    }

    private List<Lotto> initLottos(final Amount purchaseAmount) {
        final List<Lotto> lottos = new ArrayList<>();

        final int purchaseCount = purchaseAmount.divideWithoutDecimal(new Amount(LOTTO_AMOUNT));

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public int purchaseCount() {
        return lottos.size();
    }

    public Winning draw(final List<Integer> winningNumbers, int bonusNumber) {

        validaitonNumber(winningNumbers, bonusNumber);

        final Winning winning = new Winning();
        for (Lotto lotto : lottos) {

            winning.addWinning(lotto.getRightNumber(winningNumbers), lotto.isRightBonusNumber(bonusNumber));
        }

        return winning;
    }

    private void validaitonNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT_MSG);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_MSG);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString() + LINE_BREAK);
        }
        return stringBuilder.toString();
    }
}
