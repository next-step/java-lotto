package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoResult.INTEGER_ZERO;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(int autoCount, List<String> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        manualLottoNumbers.stream()
                .map(manualLottoNumber -> lottos.add(Lotto.from(manualLottoNumber)))
                .collect(Collectors.toList());

        IntStream.range(INTEGER_ZERO, autoCount)
                .mapToObj(i -> lottos.add(Lotto.of(new LottoNumberRandomGenerator())))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult match(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::getRankByLotto)
                .collect(collectingAndThen(toList(), LottoResult::of));
    }

    public List<String> toStringByLotto() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}