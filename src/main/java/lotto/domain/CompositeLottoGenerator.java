package lotto.domain;

import java.util.List;

public class CompositeLottoGenerator implements LottoGenerator {

    private final List<LottoGenerator> generators;

    public CompositeLottoGenerator(List<LottoGenerator> generators) {
        this.generators = generators;
    }

    @Override
    public Lottos generate() {
        return generators.stream()
                .map(LottoGenerator::generate)
                .reduce(Lottos::merge)
                .orElseGet(Lottos::empty);
    }
}
