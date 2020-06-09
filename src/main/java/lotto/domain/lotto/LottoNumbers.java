package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final Numbers numbers = Numbers.create();
    private List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create() {
        List<LottoNumber> lottoNumbers = numbers.createLottoNumbers();
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers create(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isExist(int number) {
        for(LottoNumber lottoNumber : lottoNumbers){
            if(lottoNumber.isExist(number))
                return true;
        }
        return false;
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개 입니다");
        }
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
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
