package domain;

import java.util.*;

public class LottoNumbers {

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> numbers) {
        assertSizeOfSix(numbers);
        this.lottoNumbers = numbers;
    }

    private void assertSizeOfSix(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
    }

    public boolean isMatchFiveNumberAndBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return this.matchCount(winningNumbers) == 5 && this.lottoNumbers.contains(bonusNumber);
    }

    public int matchCount(LottoNumbers winningNumbers) {
        Set<LottoNumber> newLottoNumbers1 = new LottoNumbers(new HashSet<>(this.lottoNumbers)).lottoNumbers;
        newLottoNumbers1.retainAll(winningNumbers.lottoNumbers);
        return newLottoNumbers1.size();
    }

    public static LottoNumbers randomLottoNumbers() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(LottoNumber.random());
        }
        return new LottoNumbers(numbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
