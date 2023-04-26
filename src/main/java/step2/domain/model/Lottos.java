package step2.domain.model;

import step2.domain.strategy.lotto.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(Strategy strategy, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createLotto(strategy)); //
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        String lottoString = lottos.stream()
                .map(lotto -> String.valueOf(lotto.toString()))
                .collect(Collectors.joining("\n"));

        return String.format("%s", lottoString);
    }
}
