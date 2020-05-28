package lotto.domain.seller;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.price.PayInfo;
import lotto.domain.price.PurchaseInfo;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.ErrorMessage;

import java.util.List;
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

    public static PurchaseInfo buyTicket2(final PayInfo payInfo) {
        validatePurchaseInfo(payInfo);

        return PurchaseInfo.valueOf(
                buyManualTickets(payInfo.getManualTicketNumbers()),
                buyAutoTickets(payInfo.getAutoTicketsCount2())
        );
    }

    private static void validatePurchaseInfo(final PayInfo payInfo) {
        if (payInfo == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    private static LottoTickets buyManualTickets(final List<List<LottoNumber>> manualTickets) {
        List<LottoNumbers> lottoNumbers = manualTickets.stream()
                .map(LottoNumbers::manualCreate)
                .collect(Collectors.toList());

        return LottoTickets.of(
                lottoNumbers.stream()
                        .map(LottoTicket::of)
                        .collect(Collectors.toList()));
    }

    private static LottoTickets buyAutoTickets(final int autoTicketsCount) {
        return LottoTickets.of(
                Stream.generate(LottoNumbers::autoCreate)
                        .limit(autoTicketsCount)
                        .map(LottoTicket::of)
                        .collect(Collectors.toList())
        );
    }
}
