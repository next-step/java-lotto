package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final long PRICE = 1000L;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        return new Lotto(LottoNumbers.generateAuto());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
