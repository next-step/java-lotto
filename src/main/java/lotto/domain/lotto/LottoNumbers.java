package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final Numbers numbers = Numbers.create();
    private List<Integer> lottoNumbers;

    private LottoNumbers(List<Integer> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create() {
        List<Integer> lottoNumbers = numbers.createLottoNumbers();
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers create(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개 입니다");
        }
    }

    private void checkDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재 합니다");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }


}
