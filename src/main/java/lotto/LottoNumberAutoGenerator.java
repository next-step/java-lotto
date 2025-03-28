package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberAutoGenerator {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    public static final long LOTTO_PICK_COUNT = 6;


    public static List<Integer> generateNumbers() {
        List<Integer> pool = IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(pool);

        return pool.stream()
                .limit(LOTTO_PICK_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

}
