package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoAutoGenerator implements LottoGenerator {
    private final List<Integer> lottoNumber;

    public LottoAutoGenerator() {
        this.lottoNumber = initNumber();
        shuffleNumber();
    }

    @Override
    public List<Integer> generateLottoNumber() {
        return lottoNumber.stream()
                .limit(COUNT_LOTTO_NUMBER)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> initNumber() {
        return IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private void shuffleNumber() {
        shuffle(lottoNumber);
    }
}
