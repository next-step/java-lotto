package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    private static final int LOTTO_NUM_COUNT = 6;


    private List<Integer> lottoNumbers;

    public LottoNumbers(PickNumberStrategy pickNumberStrategy) {
        lottoNumbers = pickNumberStrategy.makeLottoNumber();
        validate();
    }

    private void validate() {
        if (!lottoNumbers.stream().allMatch(number -> (number <= MAX_LOTTO_NUM && number >= MIN_LOTTO_NUM))) {
            throw new IllegalArgumentException("1과 45사이의 값만 들어올 수 있습니다.");
        }
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또의 사이즈는 " + LOTTO_NUM_COUNT + "개만 가능합니다.");
        }
    }

    public List<Integer> getValues() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
