package autolotto.machine.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final Shuffler shuffler;

    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private static final Integer LOTTO_NUMBERS_SIZE = 6;

    public LottoGenerator(Shuffler shuffler) {
        this.shuffler = shuffler;
    }

    public Lotto generateLotto() {
        return new Lotto(generateLottoRangeNumbers());
    }

    private List<Integer> generateLottoRangeNumbers() {
        List<Integer> shuffled = shuffler.shuffle(lottoRangeNumbers());

        return shuffled.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> lottoRangeNumbers() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Lotto> generateMultipleLotto(int lottoCount) {
        List<Lotto> lottoCollection = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            lottoCollection.add(generateLotto());
        }

        return lottoCollection;
    }
}
