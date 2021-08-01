package lotto.domain.lotto.number;

import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.MatchInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        validate(lottoNumberSet);
        this.lottoNumbers = lottoNumberSet;
    }

    private void validate(Set<LottoNumber> lottoNumberSet) {
        if (Objects.isNull(lottoNumberSet) || lottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호는 총 6개여야 합니다");
        }
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber::equals);
    }

    public MatchInfo match(WinningLotto winningLotto) {
        return MatchInfo.of(matchCount(winningLotto), matchBonusNumber(winningLotto));
    }

    private int matchCount(WinningLotto winningLotto) {
        return Math.toIntExact(lottoNumbers.stream().filter(winningLotto::contains).count());
    }

    private boolean matchBonusNumber(WinningLotto winningLotto) {
        return lottoNumbers.stream().anyMatch(winningLotto::containsBonusNumber);
    }

}

