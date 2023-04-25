package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto() {
        this.numbers = this.getNumbers();
    }

    private List<Number> getNumbers() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(Number.MIN_NUMBER, Number.MAX_NUMBER)
                                              .boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE).stream().map(Number::new).sorted().collect(Collectors.toList());
    }

    public Lotto(int... numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException("숫자는 6개만 입력 가능합니다.");
        }
        this.numbers = Arrays.stream(numbers).mapToObj(Number::new).sorted().collect(Collectors.toList());
    }

    public List<Number> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

    public long matchNumber(List<Number> winNumbers) {
        return this.numbers.stream().filter(winNumbers::contains).count();
    }

    public long matchBonusNumber(Number bonusNumber) {
        return Collections.frequency(numbers, bonusNumber);
    }
}
