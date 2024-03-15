package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public JudgeResult judge(Lotto winningLotto) {
        int[] matchCount = new int[7];
        for (Lotto lotto : lottos) {
            matchCount[lotto.countMatchingBalls(winningLotto)]++;
        }
        return new JudgeResult(matchCount[3], matchCount[4], matchCount[5], matchCount[6]);
    }

    public List<Lotto> value() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }
}
