package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Lotto> lottos = new ArrayList<>();

    public WinningLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    void winNCheckNumber(List<Integer> inputPickNumbers) {
        for(Lotto lotto : lottos) {
            containsCheckLotto(inputPickNumbers, lotto);
        }
    }

    private static void containsCheckLotto(List<Integer> inputPickNumbers, Lotto lotto) {
        int cntSum = 0;
        for(int pickNumber : inputPickNumbers) {
            cntSum += containsPerOneLotto(lotto, pickNumber);
            Rank.doWinResultProcess(cntSum);
        }
    }

    static int containsPerOneLotto(Lotto lotto, int pickNumber) {
        int cnt = 0;
        if(lotto.getLottoNumbers().contains(pickNumber)) {
            cnt++;
        }
        return cnt;
    }
}
