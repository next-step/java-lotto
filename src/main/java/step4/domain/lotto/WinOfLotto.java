package step4.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinOfLotto {

    private static final int MINIMAL_WIN_OF_LOTTO_NUMBERS = 7;

    private final List<LottoNumber> winOfResultWithBonus;
    private final LottoNumber bonusNumber;

    public WinOfLotto(List<LottoNumber> winOfLottos, LottoNumber bonusNumber) {
        validateWinOfLottos(winOfLottos, bonusNumber);
        this.winOfResultWithBonus = winOfLottos;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinOfLottos(List<LottoNumber> winOfLottos, LottoNumber bonusNumber) {
        Set<LottoNumber> lottos = new HashSet<>(winOfLottos);
        lottos.add(bonusNumber);

        if (lottos.size() != MINIMAL_WIN_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("이미 존재하는 로또 번호입니다.");
        }
    }

    public int correctCount(List<LottoNumber> numbers) {
        return (int) numbers.stream()
            .filter(winOfResultWithBonus::contains)
            .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.numbers().stream().anyMatch(bonusNumber::equals);
    }

}
