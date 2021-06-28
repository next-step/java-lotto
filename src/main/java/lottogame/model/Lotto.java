package lottogame.model;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    private Set<LottoNumber> numbers;

    public Lotto(final Set<Integer> numbers) {
        this.numbers = new TreeSet<>(
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
        );
    }

}
