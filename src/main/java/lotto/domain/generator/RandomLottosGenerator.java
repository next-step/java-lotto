package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottosGenerator implements LottosGenerator {

    @Override
    public List<Lotto> generate(int lottoCount) {

        if (lottoCount < 0) {
            throw new IllegalArgumentException("로또 개수는 0 이상이어야합니다.");
        }

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(new RandomLottoGenerator()))
                .collect(Collectors.toList());
    }
}
