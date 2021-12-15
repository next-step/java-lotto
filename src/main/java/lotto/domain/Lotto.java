package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final List<LottoNumber> baseNumbers = IntStream.rangeClosed(RANGE_START, RANGE_END).mapToObj(LottoNumber::new).collect(Collectors.toList());

    private final Set<LottoNumber> numbers;

    public Lotto() {
        Collections.shuffle(baseNumbers);
        this.numbers = new TreeSet<>(baseNumbers.subList(0, SIZE));
    }

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        checkArgumentValidation(lottoNumbers);
        this.numbers = new TreeSet<>(lottoNumbers);
    }

    private void checkArgumentValidation(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("Lotto의 List<Integer> size는 항상 6입니다.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public int match(Lotto prizeNumbers) {
        return (int) this.numbers.stream().filter(prizeNumbers.numbers::contains).count();
    }
}
