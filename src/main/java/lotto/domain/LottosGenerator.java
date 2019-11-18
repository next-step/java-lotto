package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottosGenerator {
    Lottos generate(List<Lotto> lottos);
}
