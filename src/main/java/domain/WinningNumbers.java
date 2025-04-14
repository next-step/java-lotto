package domain;

import java.util.List;

import static domain.Lotto.convertLottoNumberList;
import static domain.LottoGenerator.DRAW_NUMBER_COUNT;

public class WinningNumbers {
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = new BonusNumber(bonusNumber, this.winningLotto);
    }

    public WinningNumbers(List<Integer> lottoNumberList, int bonusNumber) {
        this.winningLotto = new Lotto(lottoNumberList);
        this.bonusNumber = new BonusNumber(bonusNumber, this.winningLotto);
    }

    public boolean isMatch(LottoNumber lottoNumber){
        return winningLotto.contains(lottoNumber);
    }

    public BonusNumber getBonusNumber(){
        return this.bonusNumber;
    }
}
