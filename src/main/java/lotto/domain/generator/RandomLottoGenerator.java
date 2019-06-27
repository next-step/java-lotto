package lotto.domain.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int CHOICE_START_INDEX = 0;
    private static final int CHOICE_END_INDEX = 6;

    @Override
    public List<Integer> generate() {

        List<Integer> lottoNumberPool = createLottoNumberPool();
        shuffle(lottoNumberPool);
        return choiceLottoNumbers(lottoNumberPool);
    }

    private List<Integer> createLottoNumberPool() {

        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private void shuffle(List<Integer> lottoNumberPool) {

        Collections.shuffle(lottoNumberPool);
    }

    private List<Integer> choiceLottoNumbers(List<Integer> lottoNumberPool) {

        return lottoNumberPool.subList(CHOICE_START_INDEX, CHOICE_END_INDEX).stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}
