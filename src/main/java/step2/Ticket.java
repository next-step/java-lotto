package step2;

import java.util.List;

public class Ticket {

    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void saveLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
