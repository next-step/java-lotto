package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_COUNT = 6;

    public LottoNumbers generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(0, LOTTO_COUNT);
        Collections.sort(selectedNumbers);
        return new LottoNumbers(selectedNumbers);
    }
}
