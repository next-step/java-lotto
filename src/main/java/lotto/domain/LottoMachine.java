package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    public static List<LottoNumber> createLotto(int count) {
        List<LottoNumber> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoNumbers);
            lottos.add(new LottoNumber(new ArrayList<>(lottoNumbers.subList(0, 6))));
        }

        return lottos;
    }





}
