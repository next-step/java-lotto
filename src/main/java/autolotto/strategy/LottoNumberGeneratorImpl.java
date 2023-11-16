package autolotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;

    @Override
    public List<Integer> generateNumbers() {
        return IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.shuffle(list);
                            return list.stream()
                                    .limit(NUMBERS_PER_TICKET)
                                    .sorted()
                                    .collect(Collectors.toList());
                        }
                ));
    }
}
