package domain.lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumbers {

    Set<LottoNumber> primaryNumbers;
    LottoNumber bounusNumber;

    public WinNumbers(Set<LottoNumber> primaryNumbers, LottoNumber bounusNumber){
        this.primaryNumbers = primaryNumbers;
        this.bounusNumber = bounusNumber;
        validateNumberLength();
        validateBonusNumber();
    }

    public WinNumbers(List<LottoNumber> primaryNumbers, LottoNumber bounusNumber){
        this.primaryNumbers = new HashSet<>(primaryNumbers);
        this.bounusNumber = bounusNumber;
        validateNumberLength();
        validateBonusNumber();
    }

    public WinNumbers(List<Integer> primaryNumbers, int bounusNumber){
        this.primaryNumbers = primaryNumbers.stream().map(LottoNumber::of).collect(
            Collectors.toSet());
        this.bounusNumber = LottoNumber.of(bounusNumber);
        validateNumberLength();
        validateBonusNumber();
    }

    public int getMatchCount(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .reduce(0, (acc, number) -> acc + ( isInLotto(number) ? 1 : 0));
    }

    private boolean isInLotto(Integer number) {
        return primaryNumbers.contains(LottoNumber.of(number)) || number.equals( bounusNumber.getNumber());
    }

    private void validateNumberLength(){
        if(this.primaryNumbers.size() != 6){
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateBonusNumber(){
        if(this.primaryNumbers.contains(bounusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
        }
    }
}
