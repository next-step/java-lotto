package study.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

import static study.step2.domain.LottoNumber.validateNumbers;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;
    private int hitCount = 0;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public Rank matches(WinningNumbers winningNumbers) {
        lottoNumbers.forEach(number -> calculateHitCount(number, winningNumbers));
        return Rank.valueOfHitCount(hitCount);
    }

    private void calculateHitCount(LottoNumber number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            hitCount += 1;
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public int hitCount() {
        return hitCount;
    }

}
