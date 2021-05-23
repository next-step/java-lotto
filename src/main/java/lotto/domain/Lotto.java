package lotto.domain;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public Lotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        validateLottoNumbers();
    }

    public Lotto(Collection<LottoNumber> numbers, LottoNumber bonusNumber) {
        this(new LottoNumbers(numbers), bonusNumber);
    }

    public static Lotto of(Collection<Integer> numbers, LottoNumber bonusNumber) {
        return new Lotto(numbers.stream()
                                .map(LottoNumber::of)
                                .collect(toList()), bonusNumber);
    }

    public WinningType getWinningType(Lotto lotto) {
        return WinningType.find(getMatchCount(lotto), isBonusMatched(lotto));
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 6개의 로또 번호와 다른 번호로 사용해야 합니다.");
        }
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto.lottoNumbers);
    }

    private boolean isBonusMatched(Lotto lotto) {
        return bonusNumber.equals(lotto.bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString() + ", " + bonusNumber;
    }
}
