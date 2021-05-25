package lotto.domain;


import java.util.List;

public class WinningLotto {
    public final Lotto lotto;
    public final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }
}
