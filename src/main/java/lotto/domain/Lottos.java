package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.List;
import java.util.Objects;

public class Lottos {

    public final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public LottoResult getLottoResult(Lotto winningLotto, Integer bonusNumber) {
        ExceptionHandler.validDuplicatedBonusNumber(winningLotto, bonusNumber);
        LottoResult lottoResult = LottoResult.of();
        for (Lotto lotto : lottos) {
            lottoResult.win(lotto.getRank(winningLotto, bonusNumber));
        }
        return lottoResult;
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
