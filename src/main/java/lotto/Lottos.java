package lotto;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        generateLottos(count);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public void calculateAllMatchCount(Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.calculateMatchCount(winningLotto, bonusNumber);
        }
    }
}
