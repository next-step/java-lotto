package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static controller.LottoGame.LAST_INDEX_LOTTO;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LAST_INDEX_LOTTO) {
            throw new IllegalArgumentException("The number of lotto numbers should be exactly 6.");
        }

        lottoNumbers = new ArrayList<>();
        numbers.forEach(number ->
                this.lottoNumbers.add(new LottoNumber(number)));
        Collections.sort(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int compareWithWinningNumber(Lotto winningNumber) {
        return (int) winningNumber.lottoNumbers
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }
}
