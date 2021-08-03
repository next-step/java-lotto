package lottos.domain;

import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COUNT_OF_LOTTO = 6;
    private List<Integer> elements;

    public Lotto(LottoGenerator generator) {
        this.elements = generator.generate();
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new LottoSizeIncorrectException();
        }
        this.elements = numbers;
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public Result match(Lotto lotto) {
        int countOfMatchers = (int) (lotto.getElements()
                .stream()
                .filter(elements::contains)
                .count());
        return new Result(WinningPrize.findByNumberOfMatchers(countOfMatchers));
    }

    public List<Result> match(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::match)
                .collect(Collectors.toList());
    }
}
