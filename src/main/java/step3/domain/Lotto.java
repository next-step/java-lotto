package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatched(List<Integer> winningNumbers) {
        int numberOfMatched = 0;
        for (Integer winninNumber : winningNumbers) {
            numberOfMatched += lottoNumbers.contains(new LottoNumber(winninNumber)) ? 1 : 0;
        }
        return numberOfMatched;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}