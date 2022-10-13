package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAX_LOTTO_NUMBER = 46;

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.range(1, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Lotto> produces(Consumer<List<Integer>> shuffler, int toProduceLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < toProduceLottoCount; i++) {
            shuffler.accept(lottoNumbers);
            lottos.add(createLotto(lottoNumbers));
        }
        return lottos;
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        List<Integer> collect = lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());

        return Lotto.of(collect);
    }
}
