package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String LINE_BREAK = "\n";

    private List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final Amount amount) {
        this.lottos = initLottos(amount);
    }

    public Lottos(final List<Lotto> manualLottos, final Amount amount) {
        List<Lotto> lottoList = new ArrayList<>(manualLottos);

        lottoList.addAll(initLottos(amount));

        this.lottos = lottoList;
    }

    private List<Lotto> initLottos(final Amount amount) {
        final List<Lotto> lottos = new ArrayList<>();

        final Amount lottoCount = amount.divide(Amount.lotto());

        for (int i = 1; i <= lottoCount.get(); i++) {
            lottos.add(Lotto.auto());
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
