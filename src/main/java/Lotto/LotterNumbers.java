package Lotto;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotterNumbers {

    List<Integer> lottoNumbers;
    public static int LOTTO_COUNT = 6;


    public LotterNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() > LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호는 6자리 이상일수 없습니다. ");
        }
        this.lottoNumbers = verifyLottoNumber(lottoNumbers);
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

    private List<Integer> verifyLottoNumber(List<Integer> lottoNumber) {

        lottoNumber = lottoNumber.stream()
                .filter(number -> number > 0 && number < 46)
                .collect(Collectors.toList());
        if (lottoNumber.size() < LOTTO_COUNT) {
            throw new IllegalArgumentException("로또는 1 ~45 범위여야 합니다 ");
        }
        return lottoNumber;
    }

}
