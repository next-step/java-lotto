package lotto.domain.ticket;

import lotto.domain.dto.ManualNumberDto;
import lotto.domain.number.LottoNumber;
import lotto.domain.WinningSheet;

import java.util.List;

public class LottoWinningTicket {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningTicket(ManualNumberDto manualNumberDto, int bonusNumber) {
        validateDuplicateBonusNumber(manualNumberDto.getManualNumbers(), bonusNumber);

        this.winningTicket = LottoTicket.ofFixed(manualNumberDto.getManualNumbers());
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }

    public LottoTicket getWinningTicket() {
        return winningTicket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될 수 없습니다. - " + bonusNumber);
        }
    }

    public WinningSheet findMatchingSheet(LottoTicket lottoTicket) {
        return WinningSheet.findByMatchCount(lottoTicket.findMatchCount(winningTicket)
                , lottoTicket.isContainingLottoNumbers(bonusNumber));
    }
}
