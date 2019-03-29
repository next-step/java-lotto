package domain;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static util.Constants.LOTTO_NUMBER;

public class Lotto {
    private Set<LottoNo> numbers;

    private Lotto(Set<LottoNo> numbers) {
        assert numbers.size() == LOTTO_NUMBER;

        this.numbers = numbers;
    }

    public static Lotto of(int... numbers) {
        Set<LottoNo> numberSet = Arrays.stream(numbers)
                .mapToObj(it -> LottoNo.of(it))
                .collect(Collectors.toSet());

        return new Lotto(numberSet);
    }

    public static Lotto of(String[] numbers) {
        Set<LottoNo> numberSet = Arrays.stream(numbers)
                .mapToInt(it -> Integer.parseInt(StringUtils.trimWhitespace(it)))
                .mapToObj(it -> LottoNo.of(it))
                .collect(Collectors.toSet());

        return new Lotto(numberSet);
    }

    long count(Lotto numbers) {
        return this.numbers.stream()
                .filter(it -> numbers.hasNumber(it))
                .count();
    }

    boolean hasNumber(LottoNo number) {
        return this.numbers.contains(number);
    }

    boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
