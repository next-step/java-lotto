package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class CompositeLottosGenerator implements LottosGenerator {
    private final List<LottosGenerator> children;

    public CompositeLottosGenerator(List<LottosGenerator> children) {
        if (children == null || children.isEmpty()) {
            throw new IllegalArgumentException("children must not be empty");
        }
        this.children = List.copyOf(children);
    }

    public static CompositeLottosGenerator of(LottosGenerator... children) {
        return new CompositeLottosGenerator(Arrays.asList(children));
    }

    @Override
    public Lottos generate() {
        List<Lotto> merged = new ArrayList<>();
        for (LottosGenerator child : children) {
            merged.addAll(child.generate().values()); // Lottos.values() 필요
        }
        return new Lottos(merged);
    }
}
