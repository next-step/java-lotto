package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int sameAs(LottoNumbers winnerNumbers) {
        int numbers = 0;
        for (Integer winnerNumber:winnerNumbers.lottoNumbers) {
            numbers += contains(winnerNumber);
        }
        return numbers;
    }

    private int contains(int winnerNumber){
        if(this.lottoNumbers.contains(winnerNumber))
            return 1;
        return 0;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
