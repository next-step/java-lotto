package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int REQUIRED_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
        Collections.shuffle(numbers);
        this.lottoNumbers = numbers.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public int matchCount(Lotto winningLotto) {
        return (int) this.lottoNumbers.stream()
                .filter(winningLotto.getLottoNumbers()::contains)
                .count();
    }
}
