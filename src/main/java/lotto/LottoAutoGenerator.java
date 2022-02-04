package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {

    private static final LottoAutoGenerator INSTANCE = new LottoAutoGenerator();
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> allNumber;

    public static LottoAutoGenerator getInstance() {
        return INSTANCE;
    }

    private LottoAutoGenerator() {
        allNumber = IntStream.range(LOTTO_START_NUM, LOTTO_END_NUM)
            .boxed()
            .collect(Collectors.toList());
    }

    public List<Integer> generateLotto() {
        Collections.shuffle(allNumber);

        return allNumber.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList());
    }
}
