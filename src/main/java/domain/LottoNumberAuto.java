package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoNumberAuto implements LottoNumber {
    private List<Integer> lottoNumberPool = new ArrayList<>();

    private final static int START_LOTTO_NUMBER = 1;
    private final static int END_LOTTO_NUMBER = 45;
    private final static int COUNT_LOTTO_NUMBER = 6;

    public LottoNumberAuto() {
        initLottoNumberPool();
        shuffleLottoNumberPool();
    }

    public void initLottoNumberPool() {
        lottoNumberPool = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public void shuffleLottoNumberPool() {
        shuffle(lottoNumberPool);
    }

    @Override
    public List<Integer> generateLottoNumber() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < COUNT_LOTTO_NUMBER; i++) {
            lotto.add(lottoNumberPool.get(i));
        }
        return lotto.stream().sorted().collect(Collectors.toList());
    }
}
