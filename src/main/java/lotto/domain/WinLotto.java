package lotto.domain;

import lotto.utils.StringToInt;
import lotto.utils.StringToList;
import lotto.view.InputView;

public class WinLotto {
    Lotto winLottoNum;
    BonusNum bonusNum;

    public WinLotto(Lotto winLottoNum, BonusNum bonusNum){
        this.winLottoNum = winLottoNum;
        this.bonusNum = bonusNum;
    }

    public boolean matchBonusNum(Lotto lotto){
        return lotto.getLottoList().contains(lotto);
    }

    public BonusNum getBonusNum(){
        return bonusNum;
    }
}
