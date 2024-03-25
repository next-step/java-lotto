package lotto.domain.lotto;

import lotto.domain.rank.Ranks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(String[][] lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public Lottos() {}

    public Lottos(List<Lotto> lottos) {
        if (lottos != null && !lottos.isEmpty()) {
            this.lottos.addAll(lottos);
        }
    }

    public boolean isEmpty() {
        return lottos.isEmpty();
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<Lotto> action) {
        lottos.forEach(action);
    }

    public Ranks ranks(WinningLotto winningLotto) {
        return new Ranks(lottos.stream()
                .map(lotto -> lotto.rank(winningLotto))
                .collect(Collectors.toList()));
    }

}
