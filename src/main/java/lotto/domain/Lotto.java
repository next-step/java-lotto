package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private MatchingResult matchingResult;

    public Lotto(List<Integer> lottoNumbers) {
        validationNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validationNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalStateException("로또 번호는 6자리여야 합니다.");
        }
    }

    public void match(List<Integer> answer) {
        List<Integer> matchingNumbers = this.lottoNumbers.stream()
                .filter(number -> answer.contains(number))
                .collect(Collectors.toList());

        this.matchingResult = new MatchingResult(matchingNumbers);
    }

    public MatchingResult getMatchingResult() {
        return this.matchingResult;
    }

    public int matchingCount() {
        return this.matchingResult.matchingNumberCount();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
