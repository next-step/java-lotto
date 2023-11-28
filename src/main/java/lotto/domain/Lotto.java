package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    protected static final String LOTTO_NUMBERS_DUPLICATION_EXCEPTION = "로또 숫자에 중복이 존재합니다.";
    protected static final String LOTTO_NUMBERS_SIZE_EXCEPTION = "로또를 이루는 숫자가 6개가 아닙니다.";
    protected static final int CORRECT_LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = createLotto(lottoNumbers);
    }

    public Lotto(Integer... lottoNumber) {
        // 문제의 코드에서 나오는 오류는 다른 생성자를 호출하는 부분에서 발생하고 있습니다.
        // Java에서 생성자 내에서 다른 생성자를 호출할 때는 해당 호출이 반드시 첫 번째 문장이어야 합니다.
        // 여러 생성자가 상호 호출될 때, 이 호출은 항상 첫 번째 문장이어야 합니다.
        this(Arrays.stream(lottoNumber).map(LottoNumber::valueOf).collect(Collectors.toList()));
    }

//    public Lotto(List<Integer> lottoNumbers) {
//        this(lottoNumbers.stream().map(LottoNumber::valueOf).collect(Collectors.toList()));
//    }

    private void validateLotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_EXCEPTION);
        }
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new LinkedHashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_EXCEPTION);
        }
    }

    private Set<LottoNumber> createLotto(List<LottoNumber> lottoNumbers) {
        return new LinkedHashSet<>(lottoNumbers);
    }

    public Rank findRankBy(WinnerLotto winnerLotto) {
        int countOfMatch = winnerLotto.countOfMatch(this.lottoNumbers);
        boolean containsBonus = winnerLotto.containsBonus(this.lottoNumbers);
        return Rank.valeOf(countOfMatch, containsBonus);
    }

    public Set<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public boolean isOverlapping(LottoNumber number) {
        return this.lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber == number);
    }

    public int countOfMatch(Set<LottoNumber> lotto) {
        return (int) lotto.stream().filter(this.lottoNumbers::contains).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
