package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(ResultView::printLottoTicket);
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String printLottoTicket = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + printLottoTicket + "]");
    }
}
