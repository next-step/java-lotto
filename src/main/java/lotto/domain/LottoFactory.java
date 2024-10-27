package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final List<Integer> numbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());

    private static final Random random = new Random();

    public static Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto createLottoWithRandomNumbers() {
        Collections.shuffle(numbers, random);
        return createLotto(numbers.subList(0, 6));
    }
}
