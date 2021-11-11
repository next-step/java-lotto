package lotto.vo;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public static Lottos create(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public int count() {
        return lottos.size();
    }

    public List<WinningRank> checkWinning(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.checkWinning(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottos.stream()
                .map(lotto -> Lotto.create(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
