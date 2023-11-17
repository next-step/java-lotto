package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";
    private static final int LOTTO_AMOUNT = 1000;

    private List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final Amount amount) {
        this.lottos = initLottos(amount);
    }

    private List<Lotto> initLottos(final Amount amount) {
        final List<Lotto> lottos = new ArrayList<>();

        final Amount lottoCount = amount.divide(new Amount(LOTTO_AMOUNT));

        for (int i = 1; i <= lottoCount.get(); i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public int purchaseCount() {
        return lottos.size();
    }
    public Winning draw(final WinningNumber winningNumber) {

        final Winning winning = new Winning();
        for (Lotto lotto : lottos) {

            winning.addWinning(winningNumber.getRightNumber(lotto), winningNumber.isRightBonusNumber(lotto));
        }

        return winning;
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
