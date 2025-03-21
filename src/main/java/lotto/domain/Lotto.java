package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<Integer> lottoNumbers;

    public Lotto(Collection<Integer> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        this.validate();
    }

    private void validate() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public int getMatchCount(WinningLotto winningLotto) {
        return (int) this.lottoNumbers.stream()
            .filter(winningLotto::contains)
            .count();
    }

    public LottoRank getRank(WinningLotto winningLotto) {
        return LottoRank.getRank(winningLotto, this);
    }

    @Override
    public String toString() {
        List<Integer> lottoNumbers
            = new ArrayList<>(this.lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
