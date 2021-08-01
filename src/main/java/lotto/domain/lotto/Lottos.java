package lotto.domain.lotto;

import lotto.domain.prize.LottoPrize;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    protected Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    protected void validate(List<Lotto> lottos) {
        if (Objects.isNull(lottos) || lottos.isEmpty()) {
            throw new IllegalStateException("lotto 리스트는 null이거나 empty면 안됩니다");
        }
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public boolean isEmpty() {
        return lottos.isEmpty();
    }

    public Lottos combine(Lottos anotherLottos) {
        if (anotherLottos == null) {
            return this;
        }

        return Lottos.of(getCombinedLottos(anotherLottos));
    }

    private List<Lotto> getCombinedLottos(Lottos anotherLottos) {
        return Collections.unmodifiableList(
                new ArrayList<Lotto>() {{
                    addAll(anotherLottos.getLottos());
                    addAll(lottos);
                }}
        );
    }

    public Map<LottoPrize, Long> calculateMatch(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
