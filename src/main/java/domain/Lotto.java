package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto numbers must have 6 numbers");
        }
        this.numbers = numbers;
    }

    public int match(Lotto lotto) {
        return (int) numbers.stream()
            .filter(lotto::contains)
            .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public static Lotto fromCommaString(String s) {
        String[] split = s.replaceAll("\\s+", "").split(",");

        List<LottoNumber> numbers = Arrays.stream(split)
            .mapToInt(Integer::parseInt)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return "[" +
            String.join(
                ", ",
                numbers.stream().map(LottoNumber::toString).collect(Collectors.toList())) +
            "]";
    }
}
