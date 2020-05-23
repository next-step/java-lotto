package lotto.util;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

    private Generator() {
    }

    public static List<LottoNumber> lottoNumberList(final int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static LottoNumbers lottoNumbers(final int... numbers) {
        return LottoNumbers.manualCreate(lottoNumberList(numbers));
    }

    public static LottoTicket lottoTicket(final int... numbers) {
        return LottoTicket.of(lottoNumbers(numbers));
    }

    public static WinningLottoTicket winningLottoTicket(final int... numbers) {
        return (WinningLottoTicket) WinningLottoTicket.of(lottoNumbers(numbers));
    }

    public static LottoTickets lottoTickets(final LottoTicket... lottoTickets) {
        return LottoTickets.of(Arrays.asList(lottoTickets));
    }
}
