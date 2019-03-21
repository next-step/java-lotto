package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 0;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_NUMBER_COUNT = 6;
    public List<Integer> lottoNumber;

    public LottoNumber() {
        this.lottoNumber = this.createLotto(this.initLottoNumbers());
    }

    private List<Integer> initLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(i -> lottoNumbers.add(i + 1));
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> createLotto(List<Integer> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        IntStream.range(0, MAX_LOTTO_NUMBER_COUNT).forEach(i -> lotto.add(lottoNumbers.get(i)));
        Collections.sort(lotto);
        return lotto;
    }
}
