package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumbers;

public class LottoAutoGenerator {

    private static final LottoAutoGenerator INSTANCE = new LottoAutoGenerator();
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
    private static final int LOTTO_SIZE_START = 0;
    private static final int LOTTO_SIZE_END = 6;

    private final List<Integer> allNum;

    private LottoAutoGenerator() {
        allNum = IntStream.range(LOTTO_NUM_START, LOTTO_NUM_END)
            .boxed()
            .collect(Collectors.toList());
    }

    public LottoNumbers generateLotto() {
        Collections.shuffle(allNum);
        List<Integer> lottoNums = allNum.subList(LOTTO_SIZE_START, LOTTO_SIZE_END);
        return new LottoNumbers(lottoNums);
    }

    public static LottoAutoGenerator getInstance() {
        return INSTANCE;
    }
}
