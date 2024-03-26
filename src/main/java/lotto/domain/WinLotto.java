package lotto.domain;

import java.util.List;

public class WinLotto {
    private Lotto winLottoNum;
    private BonusNum bonusNum;

    public WinLotto(Lotto winLottoNum, BonusNum bonusNum){
        List<Integer> lottoList= winLottoNum.getLottoList();
        if(lottoList.contains(bonusNum.getBonusNum())){
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복 불가");
        }

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
