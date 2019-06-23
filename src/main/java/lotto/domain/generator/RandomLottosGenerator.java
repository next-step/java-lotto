package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottosGenerator implements LottosGenerator {

    @Override
    public List<Lotto> generate(int lottoCount) {

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(new RandomLottoGenerator()))
                .collect(Collectors.toList());
    }
}
