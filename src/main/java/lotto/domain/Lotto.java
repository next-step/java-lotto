package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(new ArrayList<>());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void generateLottoNumbers(List<Integer> lottoNumber, int amount) {
        for (int i = 0; i < amount; i++) {
            LottoNumber newLottoNumber = new LottoNumber(lottoNumber);
            lottoNumbers.add(newLottoNumber);
        }
    }

    public void saveMatchResult(WinningNumber winningNumber, Match match) {
        this.lottoNumbers.forEach(iter -> {
            int matchCount = iter.getMatchCount(winningNumber);
            match.save(matchCount, iter.isBonusContains(winningNumber));
        });
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
