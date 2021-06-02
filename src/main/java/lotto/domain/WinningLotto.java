package lotto.domain;


import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    public boolean contains(LottoNumber number){
        return lotto.contains(number);
    }

}
