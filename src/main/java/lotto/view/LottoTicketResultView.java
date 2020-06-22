package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicketResultView {

    private LottoTicketResultView() {}

    public static void printBuyingLotto(final int buyingLotto) {
        System.out.println(buyingLotto + "개를 구매했습니다.");
    }

    public static void printLottoTickets(final List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            final String lottoTicketResultString = lottoTicket.getLottoNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(String.format("[%s]", lottoTicketResultString));
        }
    }

}
