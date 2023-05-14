package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        existNumber(winNumbers, bonusNumber);
        this.winNumbers = new Lotto(winNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoMatcher match(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.lottoNumbers();
        long matchedSize = lottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return LottoMatcher.of((int) matchedSize, matchBonus);
    }

    private void existNumber(List<Integer> winNumbers, Integer bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 당첨 번호입니다.");
        }
    }
}
