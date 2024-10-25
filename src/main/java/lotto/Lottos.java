package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public Lottos(Lottos lottos) {
        this.lottos = lottos.lottos;
    }

    public List<Lotto> getValues() {
        return this.lottos;
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public void calculateAllMatchCount(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.calculateMatchCount(winningLotto);
        }
    }

    public void addAll(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }
}
