package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int REQUIRED_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = auto();
    }

    LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> auto() {

        List<Integer> numbers = IntStream.rangeClosed(1, LOTTO_NUMBER_BOUND).boxed().collect(Collectors.toList());

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, REQUIRED_NUMBER_COUNT);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public int getHitCount(List<Integer> winNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonus) {
        return this.lottoNumbers.contains(bonus);
    }
}
