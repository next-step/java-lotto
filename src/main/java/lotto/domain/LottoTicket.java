package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;
    private final List<Integer> numbers;

    public LottoTicket(LottoNumbers lottoNumbers, List<Integer> numbers) {
        this.lottoNumbers = lottoNumbers;
        this.numbers = numbers;
    }

    public LottoTicket() {
        this(new LottoNumbers(new ArrayList<>()), new ArrayList<>());
    }

    public List<LottoNumber> generate() {
        return this.lottoNumbers.generate();
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return this.lottoNumbers.countMatchingWith(winningNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

}
