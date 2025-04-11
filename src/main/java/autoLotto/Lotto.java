package autoLotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    protected Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this.numbers = Arrays.stream(numbers.split(","))
                             .map(String::trim)
                             .map(Integer::parseInt)
                             .map(LottoNumber::new)
                             .collect(Collectors.toSet());
    }

    protected boolean containsNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
    }


    @Override
    public String toString() {
        String result = numbers.stream()
                               .sorted()
                               .map(LottoNumber::toString)
                               .collect(Collectors.joining(", "));
        return String.format("[%s]", result);
    }
}
