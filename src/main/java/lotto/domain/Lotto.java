package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = new TreeSet<>(parseLottoNumber(numbers));
        validate();
    }

    public Lotto(Integer... numbers) {
        this(Set.copyOf(Arrays.asList(numbers)));
    }

    private Set<LottoNumber> parseLottoNumber(Set<Integer> numbers) {
        return numbers.stream()
                .map(value -> new LottoNumber(value))
                .collect(Collectors.toSet());
    }

    private void validate() {
        if (this.numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d개이어야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    public List<LottoNumber> numbers() {
        return this.numbers.stream().collect(Collectors.toList());
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return this.numbers().contains(lottoNumber);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) winningLotto.numbers()
                .stream()
                .filter(value -> this.hasNumber(value))
                .count();
    }

}
