package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) object;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
