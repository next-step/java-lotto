package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final LottoBalls lottoBalls = new LottoBalls();
    private final int LOTTO_BALLS_COUNT = 6;

    public Lottos getLottos(int amount) {
        Lottos lottoResult = new Lottos();
        IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(generate()))
                .forEach(lottoResult::addLotto);
        return lottoResult;
    }

    public List<LottoNumber> generate() {
        return lottoBalls.generateShuffledBalls(LOTTO_BALLS_COUNT);
    }
}
