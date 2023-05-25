package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket() {
        List<Integer> numbers = new LottoNumberGenerator().generateLottoNumbers();
        Collections.shuffle(numbers);

        for(int i = 0; i < 6; i++) {
            this.lottoNumbers.add(numbers.get(i));
        }

        Collections.sort(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
