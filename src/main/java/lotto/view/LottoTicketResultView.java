package lotto.view;

import lotto.domain.ticket.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicketResultView {

    private LottoTicketResultView() {}

    public static void printBuyingLotto(final int numberOfManualLottoTicket, final int numberOfAutoLottoTicket) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                numberOfManualLottoTicket, numberOfAutoLottoTicket));
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
