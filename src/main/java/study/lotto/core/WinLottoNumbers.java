package study.lotto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers {

    private final List<LottoNumber> winLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinLottoNumbers(List<LottoNumber> winLottoNumbers, LottoNumber bonusLottoNumber) {
        this.winLottoNumbers = winLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;

        throwIfNumbersNull();
        throwIfNumberCountNotMatch();
    }

    private void throwIfNumberCountNotMatch() {
        if (winLottoNumbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해주세요.");
        }

        if (Objects.isNull(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호를 입력해주세요");
        }
    }

    private void throwIfNumbersNull() {
        if (Objects.isNull(winLottoNumbers)) {
            throw new IllegalArgumentException("당첨 번호를 입력해주세요.");
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
