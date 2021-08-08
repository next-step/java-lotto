package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final long SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != SIZE){
            throw new IllegalArgumentException("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + lottoNumbers.size());
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        for (LottoNumber lottoNumber: lottoNumbers) {
            containsThenThrowsException(lottoNumberSet, lottoNumber);
            lottoNumberSet.add(lottoNumber);
        }
    }

    private void containsThenThrowsException(Set<LottoNumber> lottoNumberSet, LottoNumber lottoNumber) {
        if(lottoNumberSet.contains(lottoNumber)){
            throw new IllegalArgumentException("LottoNumbers에 중복된 숫자가 있습니다. 중복된 숫자 : " + lottoNumber);
        }
    }

    public int countContains(LottoNumbers winnerNumbers) {
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
}
