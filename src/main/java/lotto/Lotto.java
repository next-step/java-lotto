package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final long LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(Set<Integer> numbers) {
        this.lottoNumbers = numbers.stream().map(LottoNumber::of).collect(Collectors.toSet());
        validateLottoNumbers();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank getLottoRank(Lotto winningNumbers, int bonusNumber) {
        int matchCount = (int) this.lottoNumbers.stream().filter(winningNumbers.getLottoNumbers()::contains).count();
        boolean isBonusNumber = lottoNumbers.contains(LottoNumber.of(bonusNumber));
        return LottoRank.fromMatchCount(matchCount, isBonusNumber);
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() > LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (lottoNumbers.size() < LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

}
