package lotto.domain;

import java.util.List;
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

    public int matchingCount(List<Integer> answer) {
        return (int) this.lottoNumbers.stream()
                .filter(number -> answer.contains(number))
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
