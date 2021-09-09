package step2.domain.lotto;

import step2.domain.statistics.Amount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public Lottos(Amount amount) {
        for (int i = 0; amount.isLessThan(i); i++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public Lottos add(Lottos lottos) {
        return new Lottos(
                Stream.concat(this.lottos.stream(), lottos.lottos.stream())
                        .collect(Collectors.toList()));
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
