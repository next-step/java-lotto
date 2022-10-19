package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_MATCH_NUMBER = 6;

    private List<LottoNumber> lotto;
    private NumberGenerator numberGenerator;

    public Lotto(NumberGenerator numberGenerator) {
        this.lotto = numberGenerator.generate();
        this.numberGenerator = numberGenerator;
    }

    public int getSameNumberCount(Lotto winning) {
        if (this.isEqual(winning)) return MAX_MATCH_NUMBER;

        List<LottoNumber> winningNumbers = winning.lotto;

        return winningNumbers.stream()
                .filter(winningNum -> lotto.contains(winningNum))
                .collect(Collectors.toList())
                .size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lotto;
    }

    public boolean isEqual(Lotto numbers) {
        return this.lotto.containsAll(numbers.lotto);
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
