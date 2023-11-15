package study.step2.domain;

import java.util.List;

import study.step2.domain.dto.WinningNumbers;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private int hitCount = 0;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank matches(WinningNumbers winningNumbers) {
        lottoNumbers.lottoNumbers()
            .forEach(number -> calculateHitCount(number, winningNumbers));
        return Rank.valueOfHitCount(hitCount);
    }

    private void calculateHitCount(Integer lottoNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(lottoNumber)) {
            hitCount += 1;
        }
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.lottoNumbers();
    }

    public int hitCount() {
        return hitCount;
    }

}
