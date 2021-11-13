package lotto.controller.dto;

import java.util.List;

public class WinningLottoTicketParam {
    private final List<Integer> winningLottoNumbers;
    private final Integer bonusNumber;

    private WinningLottoTicketParam(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicketParam of(List<Integer> winningLottoNumbers, Integer bonusNumbe) {
        return new WinningLottoTicketParam(winningLottoNumbers, bonusNumbe);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
