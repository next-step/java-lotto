package study.lotto.core;

import study.lotto.core.exception.LottoNumberCountNotMatchingException;

import java.util.*;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private final List<LottoNumber> winLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinLottoNumbers(Set<LottoNumber> winLottoNumbers, LottoNumber bonusLottoNumber) {
        this.winLottoNumbers = Optional.ofNullable(winLottoNumbers)
                .map(ArrayList::new)
                .orElseThrow(() -> new LottoNumberCountNotMatchingException());
        this.bonusLottoNumber = Optional.ofNullable(bonusLottoNumber)
                .orElse(LottoNumber.zero());

        throwIfNumberCountNotMatch();
    }

    public WinLottoNumbers(WinLottoNumbersBuilder winLottoNumbersBuilder) {
        this.winLottoNumbers = Optional.ofNullable(winLottoNumbersBuilder.winLottoNumbers)
                .map(ArrayList::new)
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
        private final List<LottoNumber> winLottoNumbers;
        // Optional
        private LottoNumber bonusLottoNumber;

        public WinLottoNumbersBuilder(List<LottoNumber> winLottoNumbers) {
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
