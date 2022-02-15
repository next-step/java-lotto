package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_MAX_SIZE = 6;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;

        validateSize();
    }

    public static Lotto from(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    private void validateSize() {
        if (lotto.size() > LOTTO_MAX_SIZE) {
            throw new RuntimeException("[ERROR] Lotto의 크기는 6 이하이어야 합니다.");
        }
    }
}
