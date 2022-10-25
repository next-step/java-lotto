package lotto.model;

import lotto.exception.InvalidLottoSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lotto;

    public Lotto(String[] lotto) {
        this(Arrays.stream(lotto)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);

        if (this.lotto.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException(String.format("[사이즈 오류] 로또는 6개의 숫자가 생성되어야 합니다. %s", lotto.size()));
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}