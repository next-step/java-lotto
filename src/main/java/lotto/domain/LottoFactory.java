package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final LottoNumberPool LOTTO_NUMBER_POOL = new LottoNumberPool();

    public List<Lotto> produces(Consumer<List<Integer>> shuffler, int toProduceLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < toProduceLottoCount; i++) {
            LOTTO_NUMBER_POOL.shuffle(shuffler);
            lottos.add(Lotto.of(LOTTO_NUMBER_POOL.getRandomNumbers(LOTTO_NUMBER_COUNT)));
        }
        return lottos;
    }
}
