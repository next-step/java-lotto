package step4.domain;

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
        for (Integer winningNumber : winningNumbers) {
            numberOfMatched += lottoNumbers.contains(new LottoNumber(winningNumber)) ? 1 : 0;
        }
        return numberOfMatched;
    }

    public boolean bonusMatched(int bonusNumber) {
        return lottoNumbers.contains(new LottoNumber(bonusNumber));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}