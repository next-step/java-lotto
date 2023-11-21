package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(Set<Integer> numbers) {
        Set<LottoNumberValidate> lottoNumberValidates = new LinkedHashSet<>();
        for (int number : numbers) {
            lottoNumberValidates.add(new LottoNumberValidate(number));
        }
        this.numbers = new LottoNumbers(lottoNumberValidates);
    }

    public Set<LottoNumberValidate> numbers() {
        return this.numbers.lottoNumbers();
    }

    public CorrectNumbers matchCountAndBonus(WinnerNumbers winnerNumbers) {
        return numbers.matchCountAndBonus(winnerNumbers);
    }

}
