package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히" + LOTTO_NUMBER_COUNT + "개 여야 합니다.");
        }

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }
}
