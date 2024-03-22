package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;
    private final NumberGenerateStrategy numberGenerator;

    public LottoTicket() {
        this(new ArrayList<>());
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this(LottoNumbers.of(lottoNumbers), new RandomNumberGenerator());
    }

    public LottoTicket(NumberGenerateStrategy numberGenerator) {
        this(LottoNumbers.of(numberGenerator.generate()), numberGenerator);
    }

    public LottoTicket(LottoNumbers lottoNumbers, NumberGenerateStrategy numberGenerator) {
        this.lottoNumbers = lottoNumbers;
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> generate() {
        return numberGenerator.generate();
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return this.lottoNumbers.countMatchingWith(winningNumbers);
    }

    public List<Integer> generateLottoNumbers() {
        return this.lottoNumbers.generateLottoNumbers();
    }

}
