package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COUNT_OF_LOTTO = 6;
    private List<Integer> numbers;

    public Lotto(LottoGenerator generator) {
        this.numbers = generator.generate();
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new LottoSizeIncorrectException();
        }
        this.numbers = numbers;
    }

    public List<Integer> elements() {
        return Collections.unmodifiableList(numbers);
    }

    public LottoResult match(Lotto lotto) {
        int countOfMatchers = (int) (lotto.elements()
                .stream()
                .filter(numbers::contains)
                .count());
        return new LottoResult(Prize.findByNumberOfMatchers(countOfMatchers));
    }

    public List<LottoResult> match(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::match)
                .collect(Collectors.toList());
    }
}
