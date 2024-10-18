package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_BALLS_COUNT = 6;
    private final LottoBalls lottoBalls = new LottoBalls();

    public Lottos getLottos(int amount) {
        return getLottos(amount, Collections.emptyList());
    }

    public Lottos getLottos(int amount, List<Lotto> manualLottos) {
        if (manualLottos == null) {
            manualLottos = Collections.emptyList();
        }

        Lottos lottoResult = new Lottos();
        manualLottos.forEach(lottoResult::addLotto);

        IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(generate()))
                .forEach(lottoResult::addLotto);
        return lottoResult;
    }

    public List<LottoNumber> generate() {
        return lottoBalls.generateShuffledBalls(LOTTO_BALLS_COUNT);
    }
}
