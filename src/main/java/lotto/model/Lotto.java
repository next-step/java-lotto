package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = new HashSet<>(lotto);
    }

    private void validate(Set<LottoNumber> lotto) {
        Objects.requireNonNull(lotto, "lotto는 null일 수 없습니다.");
        if (lotto.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lotto 의 사이즈는 6이어야 합니다. 입력 사이즈: " + lotto.size());
        }
    }

    public Set<LottoNumber> get() {
        return Collections.unmodifiableSet(lotto);
    }

    public int countMatchNumber(Lotto result) {
        Objects.requireNonNull(result, "matchCount를 계산하기 위한 Lotto는 null일 수 없습니다.");

        Set<LottoNumber> resultLotto = result.get();
        Set<LottoNumber> originLotto = new HashSet<>(lotto);

        originLotto.retainAll(resultLotto);
        return originLotto.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
}
