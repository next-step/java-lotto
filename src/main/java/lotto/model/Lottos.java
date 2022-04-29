package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Lottos {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> lottos;

    public Lottos(List<LottoNumber> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<LottoNumber> lottos) {
        Objects.requireNonNull(lottos, "lottos는 null일 수 없습니다.");
        if (lottos.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lottos 의 사이즈는 6이어야 합니다. 입력 사이즈: " + lottos.size());
        }
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(lottos);
    }

    public int getMatchCount(Lottos result) {
        List<LottoNumber> resultLottos = result.get();
        int length = resultLottos.size();
        int count = 0;
        for (int i = 0; i < length; i++) {
            count = updateCount(resultLottos.get(i), count);
        }
        return count;
    }

    private int updateCount(LottoNumber number, int count) {
        if (lottos.contains(number)) {
            count++;
        }
        return count;
    }
}
