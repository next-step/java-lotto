package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        assertLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void assertLotto(Set<LottoNumber> lottoNumbers) {
        assertNullOrEmpty(lottoNumbers);
        assertInvalidSize(lottoNumbers);
    }

    private void assertNullOrEmpty(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new InvalidLottoException("로또 번호가 비어 있습니다");
        }
    }

    private void assertInvalidSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoException("중복을 제외한 " + LOTTO_NUMBER_SIZE + "개의 로또 번호가 필요합니다");
        }
    }

    public Rank match(WinningLotto winningLotto) {
        if (winningLotto == null) {
            throw new InvalidLottoException("당첨 번호 정보가 존재하지 않습니다");
        }

        int matchCount = winningLotto.compareWith(this);
        boolean matchBonusBall = winningLotto.containsBonusNumberIn(this);

        return Rank.findRank(matchCount, matchBonusBall);
    }

    public List<String> mapToList() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber bonus) {
        return this.lottoNumbers.contains(bonus);
    }

    public int matchNumberCount(Lotto other) {
        Set<LottoNumber> unique = new HashSet<>(this.lottoNumbers);
        unique.retainAll(other.lottoNumbers);
        return unique.size();
    }
}
