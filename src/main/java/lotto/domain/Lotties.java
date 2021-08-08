package lotto.domain;

import java.util.*;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int getCount() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public void sameNumberCount(List<Integer> winningNumber) {
        for (int i = 0; i < lotties.size(); i++) {
            lotties.get(i).getLottoRank(winningNumber);
        }
    }
    /*
    public LottoStatistics matchResult(Lotto winningLotto) {
        // this.lotties를 순환하면서 winningLotto와 비교하여 Rank 계산
        // -> Rank의 개수를 담은 resultMap 생성
        return new LottoStatistics(resultMap);
    }
     */


}
