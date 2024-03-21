package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.Rule.MAX_NUMBER;
import static lotto.domain.Rule.NUMBERS_OF_BALLS;

// todo: lottoNumbers 일급 컬렉션 완성
public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> generate() {
        for (int i = 0; i < NUMBERS_OF_BALLS.getNumber(); i++) {
            this.lottoNumbers.add(randomNumbers().get(i));
        }
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    protected List<LottoNumber> randomNumbers() {
        for (int i = 0; i < MAX_NUMBER.getNumber(); i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

}
