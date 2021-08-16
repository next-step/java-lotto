package lotto.step3.domain;

import java.util.Set;

public class Winning {
    private Set<LottoNumber> winnerNumber;
    private LottoNumber bonusNumber;

    public Winning(Set<LottoNumber> winnerNumber, LottoNumber bonusNumber) {
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }
}
