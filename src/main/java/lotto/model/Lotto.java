package lotto.model;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    public MatchNumber matchNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        return new MatchNumber(getMatchCount(winningLottoNumbers), getMatchBonus(bonusLottoNumber));
    }

    private boolean getMatchBonus(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber);
    }

    private int getMatchCount(LottoNumbers winningLottoNumbers) {
        return (int) winningLottoNumbers.getNumberList().stream()
                .parallel()
                .filter(number -> getMatchBonus(number))
                .count();
    }
}
