package Lotto;


import java.util.Collections;
import java.util.List;

public class LotterNumbers {

    List<Integer> lottoNumbers;
    public static int LOTTO_COUNT = 6;


    public LotterNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() > LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호는 6자리 이상일수 없습니다. ");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static LotterNumbers of(List<Integer> lottoNumbers) {
        return new LotterNumbers(lottoNumbers);
    }

    public int getLottoNumberCount() {
        return lottoNumbers.size();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
