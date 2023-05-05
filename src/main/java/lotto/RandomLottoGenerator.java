package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 46;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<Integer> numbers = IntStream.range(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Lotto> generate(final int lottoBuyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoBuyCount; i++) {
            lottos.add(buyLotto());
        }
        return lottos;
    }

    private static Lotto buyLotto() {
        Collections.shuffle(numbers);
        return Lotto.buy(numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList()));
    }
}
