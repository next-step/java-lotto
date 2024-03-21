package lotto.domian;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerNumber {
    private final List<LottoNumber> winnerNumbers;

    private WinnerNumber(List<Integer> numbers){
       this.winnerNumbers = numbers.stream()
                .map(LottoNumber::of)
               .collect(Collectors.collectingAndThen(Collectors.toList()
                       , Collections::unmodifiableList));
    }

    public static WinnerNumber of(List<Integer> numbers){
        return new WinnerNumber(numbers);
    }

    public boolean containsLottoNumber(LottoNumber number){
        return this.winnerNumbers.contains(number);
    }

    public List<LottoNumber> getWinnerNumbers(){
        return winnerNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinnerNumber)) return false;
        WinnerNumber that = (WinnerNumber) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers);
    }
}
