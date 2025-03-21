package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> lottoNumbers;

    public WinningLotto(Collection<Integer> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        this.validate();
    }

    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public boolean contains(int lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
