package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_LAST_NUMBER = 45;
    private final static int NUMBER_COUNT_PER_ONE_LOTTO = 6;
    private final static List<Integer> LOTTO_NUMBER_POOL =
            IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());


    private LottoGenerator() {

    }

    public static LottoGenerator newInstance() {
        return new LottoGenerator();
    }

    public List<Lotto> generator(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < count ; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return LOTTO_NUMBER_POOL.stream().limit(NUMBER_COUNT_PER_ONE_LOTTO).collect(Collectors.toList());
    }
}
