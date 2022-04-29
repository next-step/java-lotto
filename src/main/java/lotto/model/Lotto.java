package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = new ArrayList<>(lotto);
    }

    private void validate(List<LottoNumber> lotto) {
        Objects.requireNonNull(lotto, "lotto는 null일 수 없습니다.");
        if (lotto.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lotto 의 사이즈는 6이어야 합니다. 입력 사이즈: " + lotto.size());
        }
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(lotto);
    }

    public int getMatchCount(Lotto result) {
        List<LottoNumber> resultLotto = result.get();
        int length = resultLotto.size();
        int count = 0;
        for (int i = 0; i < length; i++) {
            count = updateCount(resultLotto.get(i), count);
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
