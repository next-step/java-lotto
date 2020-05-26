package lotto.util;

import lotto.domain.ticket.WinningLottoTicket;

public class WinningLottoTicketGenerator {

    private WinningLottoTicketGenerator() {
    }

    public static WinningLottoTicket valueOf(final int bonusNumber, final int... numbers) {
        return WinningLottoTicket.valueOf(LottoNumbersGenerator.convertToLottoNumbers(numbers), bonusNumber);
    }
}
