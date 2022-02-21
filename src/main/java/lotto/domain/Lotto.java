package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> number;

    public Lotto() {
        number = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> number) {
        this.number = number;
    }

    public List<LottoNumber> getLotto() {
        return number;
    }

    public int matchWinningLotto(WinningLotto winningLotto) {
        return (int) number
            .stream()
            .filter(winningLotto.getWinLotto()::contains)
            .count();
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        return number.stream().anyMatch(bonusNumber::equals);
    }
}
