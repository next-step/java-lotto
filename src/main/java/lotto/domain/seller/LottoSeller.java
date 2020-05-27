package lotto.domain.seller;

import lotto.domain.price.PurchaseInfo;
import lotto.domain.number.LottoNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.ErrorMessage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoTickets buyTicket(final PurchaseInfo purchaseInfo) {
        validatePurchaseInfo(purchaseInfo);

        LottoTickets autoTickets = LottoTickets.of(
                Stream.generate(LottoNumbers::autoCreate)
                    .limit(purchaseInfo.getAutoTicketsCount())
                    .map(LottoTicket::of)
                    .collect(Collectors.toList())
        );
        return purchaseInfo.getManualTickets().merged(autoTickets);
    }

    private static void validatePurchaseInfo(final PurchaseInfo purchaseInfo) {
        if (purchaseInfo == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }
}
