package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int SIZE = 6;
    private final List<LottoNumber> numbers;


    public Lotto() {
        this(create());
    }

    public Lotto(String numbers) {
        this(parseNumbers(numbers));
    }

    public Lotto(int... values) {
        this(toLottoNumbers(values));
    }

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static List<LottoNumber> toLottoNumbers(int[] values) {
        return Arrays.stream(values)
                .mapToObj(LottoNumber::new)
                .toList();
    }
    
    private static List<LottoNumber> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(",", -1))
                .map(String::trim)
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 생성되어야한다.");
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없다.");
        }
    }

    private static List<LottoNumber> create() {
        List<Integer> candidates = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(candidates);
        return candidates.subList(0, SIZE).stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }


    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public MatchCount match(Lotto other) {
        return new MatchCount((int) numbers.stream()
                .filter(other::contains)
                .count());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto that = (Lotto) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}