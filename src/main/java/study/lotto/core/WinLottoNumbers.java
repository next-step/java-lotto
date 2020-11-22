package study.lotto.core;

import study.lotto.core.exception.LottoNumberCountNotMatchingException;

import java.util.*;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private final Set<LottoNumber> winLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinLottoNumbers(WinLottoNumbersBuilder winLottoNumbersBuilder) {
        this.winLottoNumbers = Optional.ofNullable(winLottoNumbersBuilder.winLottoNumbers)
                .orElseThrow(() -> new LottoNumberCountNotMatchingException());
        this.bonusLottoNumber = Optional.ofNullable(winLottoNumbersBuilder.bonusLottoNumber)
                .orElse(LottoNumber.zero());
        throwIfNumberCountNotMatch();
    }

    private void throwIfNumberCountNotMatch() {
        if (winLottoNumbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new LottoNumberCountNotMatchingException();
        }
    }

    public List<LottoNumber> matchWithWinLottoNumbers(Lotto lotto) {
        List<LottoNumber> matchingLottoNumbers = new ArrayList<>();
        // 일치하는 번호 추가
        this.winLottoNumbers.stream()
                .filter(lotto::contains)
                .forEach(matchingLottoNumbers::add);

        return matchingLottoNumbers;
    }

    public boolean matchWithBonusLottoNumber(Lotto lotto) {
        return lotto.contains(bonusLottoNumber);
    }

    public static class WinLottoNumbersBuilder {
        // Required
        private final Set<LottoNumber> winLottoNumbers;
        // Optional
        private LottoNumber bonusLottoNumber;

        public WinLottoNumbersBuilder(Set<LottoNumber> winLottoNumbers) {
            this.winLottoNumbers = winLottoNumbers;
        }

        public WinLottoNumbersBuilder bonusLottoNumber(LottoNumber bonusLottoNumber) {
            this.bonusLottoNumber = bonusLottoNumber;
            return this;
        }

        public WinLottoNumbers build() {
            return new WinLottoNumbers(this);
        }
    }
}
