package domain.lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumbers {

    Set<LottoNumber> primaryNumbers;
    LottoNumber bounusNumber;

    public WinNumbers(List<LottoNumber> primaryNumbers, LottoNumber bounusNumber){
        this.primaryNumbers = new HashSet<>(primaryNumbers);
        this.bounusNumber = bounusNumber;
    }

    public WinNumbers(List<Integer> primaryNumbers, int bounusNumber){
        this.primaryNumbers = primaryNumbers.stream().map(LottoNumber::new).collect(
            Collectors.toSet());
        this.bounusNumber = new LottoNumber(bounusNumber);
    }

    public int getMatchCount(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .reduce(0, (acc, number) -> acc + ( isInLotto(number) ? 1 : 0));
    }

    private boolean isInLotto(Integer number) {
        return primaryNumbers.contains(new LottoNumber(number)) || number.equals( bounusNumber.getNumber());
    }
}
