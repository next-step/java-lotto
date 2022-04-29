package lotto.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public final class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = new LinkedHashSet<>(lotto);
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

    public int getMatchCount(Lotto result) {
        Set<LottoNumber> resultLotto = result.get();
        int count = 0;
        for (LottoNumber lottoNumber : resultLotto) {
            count = updateCount(lottoNumber, count);
        }
        return count;
    }

    private int updateCount(LottoNumber number, int count) {
        if (lotto.contains(number)) {
            count++;
        }
        return count;
    }
}
