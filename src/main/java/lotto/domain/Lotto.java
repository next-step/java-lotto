package lotto.domain;

import lotto.utils.MessageUtils;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final Set<Integer> lotto;
    private LottoRank lottoRank;

    private Lotto(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(LottoGenerator lottoGenerator) {
        return new Lotto(lottoGenerator.create());
    }

    public Set<Integer> getLotto() {
        return this.lotto;
    }

    public void scratchLotto(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }

    public LottoRank getLottoRank() {
        if (Objects.isNull(this.lottoRank)) {
            throw new IllegalArgumentException(MessageUtils.LOTTO_BEFORE_PRESENT_WINNING);
        }
        return lottoRank;
    }
}
