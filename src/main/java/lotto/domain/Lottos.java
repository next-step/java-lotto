package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int autoCount, List<String> manualLottoNumbers) {
        List<Lotto> mergeLottos = new ArrayList<>();

        for (String manualLottoNumber : manualLottoNumbers) {
            mergeLottos.add(Lotto.from(manualLottoNumber));
        }

        for(int i = 0; i < autoCount; i++) {
            mergeLottos.add(Lotto.of(new LottoNumberRandomGenerator()));
        }
        return new Lottos(mergeLottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
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