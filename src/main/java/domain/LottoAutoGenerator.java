package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoAutoGenerator implements LottoGenerator {
    private List<Integer> lottoNumberPool = new ArrayList<>();

    public LottoAutoGenerator() {
        initLottoNumberPool();
        shuffleLottoNumberPool();
    }

    @Override
    public List<Integer> generateLottoNumber() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < COUNT_LOTTO_NUMBER; i++) {
            lotto.add(lottoNumberPool.get(i));
        }
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    private void initLottoNumberPool() {
        lottoNumberPool = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private void shuffleLottoNumberPool() {
        shuffle(lottoNumberPool);
    }
}
