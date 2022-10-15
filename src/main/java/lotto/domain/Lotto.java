package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final static int COUNTS_OF_LOTTO_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNTS_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 여섯 자리여야 합니다.");
        }
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public int compareNumber(final Lotto winningNumber) {
        return lottoNumbers().stream()
                .mapToInt(number -> winningNumber.lottoNumbers.contains(number) ? 1 : 0)
                .sum();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
