package domain;

import java.util.*;

public class Lotto {

    public static final int PRICE = 1_000;

    private final LottoNumbers lottoNumbers;
    private final List<LottoNumber> lottoNumbers1;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        this.lottoNumbers1 = new ArrayList<>();
    }

    public Rank rank(WinningLotto winningLotto) {
        return winningLotto.rank(this.lottoNumbers);
    }

    public boolean isMatchFiveNumberAndBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
//        return this.matchCount(winningNumbers) == 5 && this.lottoNumbers.contains(bonusNumber);
        return false;
    }

    public int matchCount(LottoNumbers winningNumbers) {
////        Set<LottoNumber> newLottoNumbers1 = new LottoNumbers(new HashSet<>(this.lottoNumbers)).lottoNumbers;
////        newLottoNumbers1.retainAll(winningNumbers.lottoNumbers);
//        return newLottoNumbers1.size();
        return 0;
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
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
