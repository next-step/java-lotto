package autolotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final Shuffler shuffler;

    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    private static final Integer LOTTO_PRICE = 1000;

    public LottoGenerator(Shuffler shuffler) {
        this.shuffler = shuffler;
    }

    public List<Integer> generateLottoRangeNumbers() {
        List<Integer> shuffled = shuffler.shuffle(generateOriginalLottoRangeNumbers());

        return shuffled.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto generateLotto() {
        return new Lotto(generateLottoRangeNumbers());
    }

    private List<Integer> generateOriginalLottoRangeNumbers() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Lotto> generateLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }
}
