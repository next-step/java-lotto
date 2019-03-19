package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedLottoGenerator implements LottoGenerator {
    private List<Integer> baseNumbers =
            IntStream.range(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());
    private int customIndex;

    public FixedLottoGenerator(int baseNumber) {
        this.customIndex = baseNumber - 2;
    }

    @Override
    public Lotto generateLotto() {
        customIndex++;
        return new Lotto(baseNumbers.subList(customIndex, customIndex + Lotto.SIZE_LIMIT));
    }
}
