package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCreator {

    private static final List<Integer> ORIGINAL_LOTTO_NUMBERS = makeNumbers();
    private static final Random RANDOM_INSTANCE = new Random();

    private static List<Integer> makeNumbers() {
        return Stream.iterate(1, i -> i + 1)
                .limit(45)
                .collect(Collectors.toList());
    }

    public static List<Lotto> create(final int money) {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < money / 1000; i++) {
            Collections.shuffle(ORIGINAL_LOTTO_NUMBERS, RANDOM_INSTANCE);
            lottoList.add(new Lotto(ORIGINAL_LOTTO_NUMBERS.subList(0, 6)));
        }

        return lottoList;
    }
}
