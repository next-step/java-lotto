package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    public Lottos create(List<List<Integer>> numbers) {
        return new Lottos(
            numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList())
        );
    }
}
