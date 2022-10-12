package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;
    public Lotto(List<Integer> lottoNumbers) {
        validationNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validationNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalStateException("로또 번호는 6자리여야 합니다.");
        }
    }

    public MatchingResult getMatchingResult(List<Integer> answer) {

        List<Integer> matchedNumbers = this.lottoNumbers.stream()
                .filter(number -> answer.contains(number))
                .collect(Collectors.toList());

        return new MatchingResult(matchedNumbers);
    }

    public WinningPrice getMatchingResult(WinningNumber winningNumber) {
        List<Integer> answer = winningNumber.getLottoNumbers();
        int matchingCount = (int) this.lottoNumbers.stream()
                .filter(number -> answer.contains(number))
                .count();
        boolean containBonusNumber = this.lottoNumbers.contains(winningNumber.getBonusNumber());

        return  WinningPrice.decideGrade(matchingCount, containBonusNumber);
    }


    public int matchingCount(List<Integer> answer) {
        return (int) this.lottoNumbers.stream()
                .filter(number -> answer.contains(number))
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contain(int number){
        return this.lottoNumbers.contains(number);
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
