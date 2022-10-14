package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final LottoNumbers LOTTO_NUMBERS = new LottoNumbers();

    public List<Lotto> produces(Consumer<List<Integer>> shuffler, int toProduceLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < toProduceLottoCount; i++) {
            LOTTO_NUMBERS.shuffle(shuffler);
            lottos.add(createLotto(LOTTO_NUMBERS));
        }
        return lottos;
    }

    private Lotto createLotto(LottoNumbers lottoNumbers) {
        List<Integer> collect = lottoNumbers.get()
                .stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());

        return Lotto.of(collect);
    }
}
