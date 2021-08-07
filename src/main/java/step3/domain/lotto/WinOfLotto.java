package step3.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinOfLotto {

    private final LottoNumber bonusNumber;
    private final List<LottoNumber> winOfResultWithBonus;

    public WinOfLotto(Lotto winOfLottos, LottoNumber bonusNumber) {
        validateWinOfLottos(winOfLottos, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winOfResultWithBonus = joinWinOfLottoWithBonus(winOfLottos, bonusNumber);
    }

    private List<LottoNumber> joinWinOfLottoWithBonus(Lotto winOfLottos, LottoNumber bonusNumber) {
        List<LottoNumber> joinLottoNumbers = new ArrayList<>(winOfLottos.numbers());
        joinLottoNumbers.add(bonusNumber);
        return joinLottoNumbers;
    }

    private void validateWinOfLottos(Lotto winOfLottos, LottoNumber bonusNumber) {
        if (winOfLottos.numbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 로또 번호입니다.");
        }
    }

    public int correctCount(List<LottoNumber> numbers) {
        return (int) numbers.stream()
            .filter(winOfResultWithBonus::contains)
            .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.numbers().stream()
            .anyMatch(lottoNumber -> lottoNumber.equals(this.bonusNumber));
    }

}
