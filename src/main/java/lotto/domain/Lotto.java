package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Collection<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        this.validate();
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public int getMatchCount(WinningLotto winningLotto) {
        return (int) this.lottoNumbers.stream()
            .filter(winningLotto::contains)
            .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public LottoRank getRank(WinningLotto winningLotto) {
        return LottoRank.getRank(winningLotto, this);
    }

    @Override
    public String toString() {
        List<Integer> lottoNumbers = this.lottoNumbers
            .stream()
            .map(LottoNumber::getNumber)
            .sorted()
            .collect(Collectors.toList());
        return lottoNumbers.toString();
    }
}
