package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoGame.NUMBER_BOUND;

public class AutoNumberService implements LottoNumberService {
    @Override
    public List<LottoGame> creation(Money money) {
        return IntStream.range(0, money.lottoGameCount())
                .mapToObj(i -> new LottoGame(autoNumber()))
                .collect(Collectors.toList());
    }

    private Numbers autoNumber() {
        List<Integer> numbers = new ArrayList<>(Number.lottoNumber.keySet());

        Collections.shuffle(numbers);
        numbers = reduce(numbers);
        Collections.sort(numbers);

        return new Numbers(numbers);
    }

    private List<Integer> reduce(List<Integer> numbers) {
        List<Integer> reduce = new ArrayList<>();
        for (int i = 0; i < NUMBER_BOUND; i++) {
            reduce.add(numbers.get(i));
        }
        return reduce;
    }
}
