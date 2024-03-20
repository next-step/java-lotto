package lotto;

import static lotto.Lotto.LOTTO_NUMBERS_LIMIT;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningLotto;

    public List<LottoNumber> getWinningLotto() {
        return winningLotto;
    }

    public WinningLotto(List<LottoNumber> winningLotto) {
        validLottoSize(winningLotto);
        validDuplicatedLottoNumber(winningLotto);
        this.winningLotto = winningLotto;
    }

    private void validLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("로또 하나 당 6개의 숫자를 가져야합니다.");
        }
    }

    private void validDuplicatedLottoNumber(List<LottoNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
