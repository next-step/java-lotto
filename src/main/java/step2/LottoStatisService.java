package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoStatisService {
    List<Integer> winLotto;

    public LottoStatisService(List<Integer> winLotto) {
        Collections.sort(winLotto);
        this.winLotto = winLotto;
    }

    public boolean isWin(List<Integer> lotto) {
        Collections.sort(lotto);
        return Arrays.equals(winLotto.toArray(), lotto.toArray());
    }
}
