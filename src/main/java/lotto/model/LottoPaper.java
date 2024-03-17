package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> lottos;

    public LottoPaper(List<Lotto> lottos) {
        if (lottos == null) {
            throw new InvalidLottoException("Null 허용하지 않습니다");
        }

        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public boolean isEmpty() {
        return this.lottos.isEmpty();
    }

    public Map<Integer, Integer> matches(Lotto other) {
        return this.lottos.stream()
                .map(lotto -> lotto.matches(other))
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
