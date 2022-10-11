package step2.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QrMachine {
    public static List<Integer> compareWithLastLotto(List<Lotto> autoLottoLists, Lotto lastWinner) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(7, 0));
        for (Lotto lotto : autoLottoLists) {
            int count = lotto.countSameNumber(lastWinner);
            results.set(count, results.get(count) + 1);
        }
        return results;
    }
}
