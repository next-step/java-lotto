package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";
    private static final int LOTTO_AMOUNT = 1000;
    public static final String DUPLICATE_BONUS_NUMBER_MSG = "보너스번호는 중복될 수 없습니다.";

    private List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final Amount amount) {
        this.lottos = initLottos(amount);
    }

    private List<Lotto> initLottos(final Amount amount) {
        final List<Lotto> lottos = new ArrayList<>();

        final Amount purchaseCount = amount.divide(new Amount(LOTTO_AMOUNT));

        for (int i = 1; i <= purchaseCount.get(); i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public int purchaseCount() {
        return lottos.size();
    }

    public Winning draw(final LottoNumbers winningNumbers, int bonusNumber) {

        validaitonNumber(winningNumbers, bonusNumber);

        final Winning winning = new Winning();
        for (Lotto lotto : lottos) {
            winning.addWinning(lotto.getRightNumber(winningNumbers), lotto.contains(bonusNumber));
        }

        return winning;
    }

    private void validaitonNumber(LottoNumbers winningNumbers, int bonusNumber) {
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
