package lotto.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
        Collections.shuffle(numbers);
        this.lottoNumbers = numbers.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto(String winningNumbers) {
        String[] winningNumberList = winningNumbers.replace(" ", "").split(",");
        this.lottoNumbers = Arrays.stream(winningNumberList)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
