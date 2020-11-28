package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList();
        for (int i = 1; i <= LOTTO_NUMBER_BOUND ; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> makeNewNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().limit(LOTTO_NUMBER_SIZE).sorted().collect(Collectors.toList());
    }
}
