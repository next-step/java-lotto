package study.lotto.core;

import study.lotto.core.exception.LottoNumberCountNotMatchingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private static final List<LottoNumber> emptyWinLottoNumbers = Arrays.asList(
            LottoNumber.zero(), LottoNumber.zero(), LottoNumber.zero()
            , LottoNumber.zero(), LottoNumber.zero(), LottoNumber.zero());

    private final List<LottoNumber> winLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinLottoNumbers(List<LottoNumber> winLottoNumbers, LottoNumber bonusLottoNumber) {
        this.winLottoNumbers = Optional.ofNullable(winLottoNumbers)
                .orElseThrow(() -> new LottoNumberCountNotMatchingException());
        this.bonusLottoNumber = Optional.ofNullable(bonusLottoNumber)
                .orElse(LottoNumber.zero());

        throwIfNumberCountNotMatch();
    }

    public static WinLottoNumbers empty() {
        return new WinLottoNumbers(emptyWinLottoNumbers, LottoNumber.zero());
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

}
