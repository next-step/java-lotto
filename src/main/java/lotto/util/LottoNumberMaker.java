package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoNumber.*;

public class LottoNumberMaker {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumberMaker() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER)
                .sorted()
                .collect(Collectors.toList());
    }
}
