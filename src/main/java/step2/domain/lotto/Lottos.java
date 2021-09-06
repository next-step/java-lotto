package step2.domain.lotto;

import step2.domain.statistics.Amount;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public Lottos(Amount amount) {
        for (int i = 0; amount.isLessThan(i); i++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
