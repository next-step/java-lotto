package lotto.model;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto valueOf(List<Integer> numbers) {
        return new Lotto(LottoNumbers.valueOf(numbers));
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    public MatchResult matchNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        return new MatchResult(getMatchCount(winningLottoNumbers), getMatchBonus(bonusLottoNumber));
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
