package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final LottoBalls lottoBalls = new LottoBalls();
    private final int LOTTO_BALLS_COUNT = 6;

    public LottoResult getLottos(int amount) {
        LottoResult lottoResult = new LottoResult();
        IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(generate()))
                .forEach(lottoResult::addLotto);
        return lottoResult;
    }

    public List<Integer> generate() {
        return lottoBalls.getLottoBalls(LOTTO_BALLS_COUNT);
    }
}
