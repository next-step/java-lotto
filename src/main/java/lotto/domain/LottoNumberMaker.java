package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberMaker {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Integer> lottoNumberSource;

    static {
        lottoNumberSource = new ArrayList();
        for (int i = LottoNumber.LOTTO_MIN; i <= LottoNumber.LOTTO_MAX ; i++) {
            lottoNumberSource.add(i);
        }
    }

    public static List<Integer> makeNewNumbers() {
        Collections.shuffle(lottoNumberSource);
        return lottoNumberSource.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
