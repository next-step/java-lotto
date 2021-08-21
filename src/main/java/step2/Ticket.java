package step2;

import java.util.List;

public class Ticket {

    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void saveLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 6개가 아닙니다.");
        }
    }
}
