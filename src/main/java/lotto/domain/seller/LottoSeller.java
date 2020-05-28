package lotto.domain.seller;

import lotto.domain.number.LottoNumbers;
import lotto.domain.price.PayInfo;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.ErrorMessage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoTickets buyTicket(final PayInfo payInfo) {
        validatePayInfo(payInfo);

        LottoTickets autoTickets = LottoTickets.of(
                Stream.generate(LottoNumbers::autoCreate)
                    .limit(payInfo.getAutoTicketsCount())
                    .map(LottoTicket::of)
                    .collect(Collectors.toList())
        );
        return payInfo.getManualTickets().merged(autoTickets);
    }

    private static void validatePayInfo(final PayInfo payInfo) {
        if (payInfo == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }
}
