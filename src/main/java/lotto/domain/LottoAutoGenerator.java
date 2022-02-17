package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
    private static final int LOTTO_SIZE_START = 0;
    private static final int LOTTO_SIZE_END = 6;

    private final List<LottoNumber> allNum;

    public LottoAutoGenerator() {
        allNum = IntStream.range(LOTTO_NUM_START, LOTTO_NUM_END)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());
    }

    public Lottos generateLottos(int size) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoNumbers.add(generateLotto());
        }
        return new Lottos(lottoNumbers);
    }

    public Lotto generateLotto() {
        Collections.shuffle(allNum);
        List<LottoNumber> lottoNums = allNum.subList(LOTTO_SIZE_START, LOTTO_SIZE_END);
        return new Lotto(lottoNums);
    }
}
