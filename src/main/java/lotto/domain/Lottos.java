package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottos);
    }

    public int match(Lotto winningLotto, int matchCount) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.match(winningLotto) == matchCount)
                .count();
    }

    public double calculateMargin(Lotto winningNumber, Fee fee) {
        return getReward(winningNumber) / fee.getValue();
    }

    private double getReward(Lotto winningNumber) {
        for (Lotto lotto : lottos) {

        }

        return 0;
    }
}
