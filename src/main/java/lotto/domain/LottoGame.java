package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;

import java.util.*;

import static java.lang.String.format;
import static java.util.Collections.shuffle;
import static lotto.domain.LottoNumber.*;

public class LottoGame {
    public static final List<LottoNumber> RANDOM_LOTTO_NUMBERS = initializeAllLottoNumbers();
    public static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> values;

    public LottoGame(Set<LottoNumber> values) {
        validate(values);
        this.values = values;
    }

    public int size() {
        return values.size();
    }

    public boolean find(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    public int compare(LottoGame lottoGame) {
        int result = 0;
        for(LottoNumber value : values) {
            result = lottoGame.find(value) ? result + 1 : result;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame that = (LottoGame) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public static LottoGame createAuto() {
        shuffle(RANDOM_LOTTO_NUMBERS);
        Set<LottoNumber> values = new HashSet<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            values.add(RANDOM_LOTTO_NUMBERS.get(i));
        }

        return new LottoGame(values);
    }

    public static LottoGame createManual(Set<LottoNumber> lottoNumbers) {

        return new LottoGame(lottoNumbers);
    }

    private void validate(Set<LottoNumber> values) {
        if (values.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalLottoNumberCountException();
        }
    }

    private static List<LottoNumber> initializeAllLottoNumbers() {
        List<LottoNumber> result = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            result.add(valueOf(i));
        }

        return result;
    }
}
