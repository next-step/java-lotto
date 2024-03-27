package lotto.domian;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumber {
    private final Set<LottoNumber> winnerNumbers;
    private final LottoNumber bonusNumber;

    private WinnerNumber(Set<Integer> numbers, LottoNumber bonusNumber){
       validateUniqueWinnerNumbers(numbers);
       this.winnerNumbers = numbers.stream()
                .map(LottoNumber::of)
               .collect(Collectors.collectingAndThen(Collectors.toSet()
                       , Collections::unmodifiableSet));
       checkBonusNumberDuplication(bonusNumber);
       this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber of(Set<Integer> numbers, LottoNumber bonusNumber){
        return new WinnerNumber(numbers, bonusNumber);
    }

    public boolean containsLottoNumber(LottoNumber number){
        return this.winnerNumbers.contains(number);
    }

    public boolean containsBonusNumber(LottoNumber number){
        return this.bonusNumber.equals(number);
    }

    private void checkBonusNumberDuplication(LottoNumber bonusNumber){
        if(winnerNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨번호는 보너스 번호가 될 수 없습니다.");
        }
    }

    private void validateUniqueWinnerNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없으며, 6개여야 합니다.");
        }
    }

    public Set<LottoNumber> getWinnerNumbers(){
        return winnerNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinnerNumber)) return false;
        WinnerNumber that = (WinnerNumber) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers, bonusNumber);
    }
}
