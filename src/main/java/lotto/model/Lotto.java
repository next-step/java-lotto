package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public Lotto(List<Integer> numbers) {
        checkValidity(numbers);
        Collections.sort(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<LottoNumber> value() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber number : this.numbers) {
            matchCount += addMatchCount(number, lotto);
        }
        return matchCount;
    }

    private void checkValidity(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicated(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        return distinctCount != numbers.size();
    }

    private int addMatchCount(LottoNumber number, Lotto lotto) {
        if (lotto.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> array = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(array);
        return array.subList(0, 6);
    }
}
