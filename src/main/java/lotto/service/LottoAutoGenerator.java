package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoAutoGenerator {

    private static final LottoAutoGenerator INSTANCE = new LottoAutoGenerator();
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
    private static final int LOTTO_SIZE_START = 0;
    private static final int LOTTO_SIZE_END = 6;

    private final List<LottoNumber> allNum;

    private LottoAutoGenerator() {
        allNum = IntStream.range(LOTTO_NUM_START, LOTTO_NUM_END)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public static LottoAutoGenerator getInstance() {
        return INSTANCE;
    }

    public List<LottoNumbers> generateLottos(int size) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoNumbers.add(generateLotto());
        }
        return lottoNumbers;
    }

    public LottoNumbers generateLotto() {
        Collections.shuffle(allNum);
        List<LottoNumber> lottoNums = allNum.subList(LOTTO_SIZE_START, LOTTO_SIZE_END);
        return new LottoNumbers(lottoNums);
    }
}
