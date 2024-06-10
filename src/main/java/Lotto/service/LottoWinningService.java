package Lotto.service;

import Lotto.domain.Lotto;

import java.util.List;

public class LottoWinningService {
    private final Lotto winLotto;
    private final int bonusNumber;


    public LottoWinningService(Lotto winLotto, int bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public int compareLotto(Lotto lotto) {
        int count = 0;
        List<Integer> currentLotto = lotto.getLottoNumber();
        for(int i=0;i<currentLotto.size(); i++){
            if (winLotto.getLottoNumber().contains(currentLotto.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean compareLottoBonus(Lotto lotto) {
        return lotto.getLottoNumber().contains(bonusNumber);
    }
}
