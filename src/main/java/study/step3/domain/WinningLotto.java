package study.step3.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private LottoTicket winningLottoTicket;
    private BonusBall bonusBall;

    public WinningLotto(String winningLottoNumbers, int bonusBall) {
        this(new LottoTicket(winningLottoNumbers), new BonusBall(bonusBall));
    }

    public WinningLotto(LottoTicket winningLottoTicket, BonusBall bonusBall) {
        bonusBall.validateDuplicationBonusBall(winningLottoTicket.getLottoNumbers());
        this.winningLottoTicket = winningLottoTicket;
        this.bonusBall = bonusBall;
    }

    public List<LottoNumber> getLottoNumbers(){
        return winningLottoTicket.getLottoNumbers();
    }

    public boolean isMatchBonus(Set<LottoNumber> lottoNumbers) {
        return bonusBall.isMatch(lottoNumbers);
    }
}
