package step2.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    public List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> compareWithLastLotto(LastWinner lastWinner) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(7, 0));
        for (Lotto lotto : this.lottos) {
            int count = lotto.countSameNumber(lastWinner);
            results.set(count, results.get(count) + 1);
        }
        return results;
    }
}
