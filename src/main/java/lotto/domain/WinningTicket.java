package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningTicket {

    private LottoTicket winningNumber;
    private LottoNumber bonusNumber;


    public WinningTicket(List<Integer> winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = new LottoTicket(winningNumber);
        validateDuplicateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(LottoNumber bonusNumber) {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복되는 번호입니다.");
        }
    }

    public Map<LottoRank, Integer> countMatching(LottoTickets lottoTickets) {
        return lottoTickets.calculateSameNumberCounts(winningNumber, bonusNumber);
    }
}
