package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class WinningLotto {
    final private LottoTicket winningTicket;
    final private LottoNum bonus;

    public WinningLotto(String lastWeekWinningInput, LottoNum bonus) {
        this.winningTicket = LottoTicket.ofString(lastWeekWinningInput);
        checkOverlaid(bonus);
        this.bonus = bonus;
    }

    private void checkOverlaid(LottoNum bonus) {
        if (winningTicket.matchNumber(bonus)) {
            throw new IllegalArgumentException("보너스 번호가 이미 생성된 당첨 번호와 겹칩니다.");
        }
    }

    public Set<LottoNum> getWinningLottoNums() {
        return Collections.unmodifiableSet(winningTicket.getLottoNums());
    }

    public LottoNum getBonus() {
        return bonus;
    }
}
