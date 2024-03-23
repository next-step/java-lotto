package lotto.domain;

import lotto.utils.StringToInt;
import lotto.utils.StringToList;
import lotto.view.InputView;

public class WinLotto {
    private Lotto winLottoNum;
    private BonusNum bonusNum;

    public WinLotto(Lotto winLottoNum, BonusNum bonusNum){
        this.winLottoNum = winLottoNum;
        this.bonusNum = bonusNum;
    }

    public BonusNum getBonusNum(){
        return this.bonusNum;
    }
    public Lotto getWinLottoNum(){
        return this.winLottoNum;
    }
}
