package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {

    private final List<Integer> LOTTO_ALL_NUM;
    private static final LottoAutoGenerator INSTANCE = new LottoAutoGenerator();

    private LottoAutoGenerator(){
        LOTTO_ALL_NUM = IntStream.range(1, 45)
            .boxed()
            .collect(Collectors.toList());
    }

    public List<Integer> generateLotto(){
        Collections.shuffle(LOTTO_ALL_NUM);

        return LOTTO_ALL_NUM.subList(0, 6);
    }

    public static LottoAutoGenerator getInstance(){
        return INSTANCE;
    }
}
