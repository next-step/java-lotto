package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.policy.DrawPolicy;

public class LottoMachine {
    private final List<Integer> candidates;
    private final DrawPolicy drawPolicy;

    public LottoMachine(DrawPolicy drawPolicy) {
        this.drawPolicy = drawPolicy;
        candidates = new ArrayList<>(LottoConstant.END_NUMBER);

        for (int i = LottoConstant.START_NUMBER; i <= LottoConstant.END_NUMBER; i++) {
            candidates.add(i);
        }
    }

    private void applyDrawPolicy() {
        drawPolicy.apply(candidates);
    }

    public Lotto generate() {
        applyDrawPolicy();

        return new Lotto(new ArrayList<>(candidates.subList(0, 6)));
    }

}
