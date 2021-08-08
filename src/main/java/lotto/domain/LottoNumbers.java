package lotto.domain;

import java.util.List;

public class LottoNumbers {
    public static final long SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != SIZE){
            throw new IllegalArgumentException("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + lottoNumbers.size());
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int sameAs(LottoNumbers winnerNumbers) {
        int numbers = 0;
        for (LottoNumber winnerNumber : winnerNumbers.getLottoNumbers()) {
            numbers += contains(winnerNumber);
        }
        return numbers;
    }

    private int contains(LottoNumber winnerNumber) {
        if (this.lottoNumbers.contains(winnerNumber))
            return 1;
        return 0;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
