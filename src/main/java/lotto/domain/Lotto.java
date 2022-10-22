package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumbers;
    public Lotto(List<Integer> lottoNumbers) {
        validationNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    private void validationNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalStateException("로또 번호는 6자리여야 합니다.");
        }
    }

    public WinningPrice winningPrice(WinningNumber winningNumber) {

        MatchingResult matchingResult = winningNumber.results(this.lottoNumbers);

        return  WinningPrice.decideGrade(matchingResult);
    }


    public int matchingCount(List<LottoNumber> targetNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(number -> targetNumbers.contains(number))
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contain(int number){
        return this.lottoNumbers.contains(number);
    }


}
