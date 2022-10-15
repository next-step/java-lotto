package step3.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    public final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> compareWithLastLotto(LastWinner lastWinner) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(7, 0));
        for (Lotto lotto : this.lottos) {
            int count = lotto.countSameNumber(lastWinner);
            int position = getPosition(count, lotto, lastWinner.bonus);
            results.set(position, results.get(position) + 1);
        }
        return results;
    }

    private int getPosition(int count, Lotto lotto, int bonus) {
        if (count == 4 && lotto.isContain(bonus) == 1) {
            return 0;
        }
        return count;
    }
}
