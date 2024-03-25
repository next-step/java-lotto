package domain;

import java.util.*;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        assertSizeOfSix(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void assertSizeOfSix(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
    }

    public boolean match(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public int matchCount(Lotto winningLotto) {
        List<LottoNumber> newLottoNumbers = new ArrayList<>(this.lottoNumbers);
        newLottoNumbers.retainAll(winningLotto.lottoNumbers);
        return newLottoNumbers.size();
    }

    public boolean isMatchFiveNumberAndBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        return this.matchCount(winningLotto) == 5 && this.match(bonusNumber);
    }

    public static Lotto randomLotto() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_SIZE) {
            numbers.add(LottoNumber.random());
        }
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
