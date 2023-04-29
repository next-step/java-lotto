package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosFactory {
    public static Lottos createAuto(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(makeRandomLotto());
        }

        return new Lottos(lottoList);
    }

    private static Lotto makeRandomLotto() {
        List<Integer> numbers = IntStream.rangeClosed(
                        Lotto.MINIMUM_LOTTO_NUMBER,
                        Lotto.MAXIMUM_LOTTO_NUMBER
                )
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return Lotto.from(numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE));
    }
}
