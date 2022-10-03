package lotto.view;

import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.User;

public class OutputView {
    private static final String NUMBER_OF_TICKETS_FORMAT_STRING = "%d개를 구매했습니다.\r\n";

    public void printTickets(User user) {
        System.out.printf(NUMBER_OF_TICKETS_FORMAT_STRING, user.getLottoTickets().size());
        user.getLottoTickets().forEach(this::printLottoTicket);
        System.out.println();
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        String numberString = lottoTicket.getLottoNumbers().stream()
            .map(LottoNumber::getValue)
            .map(Object::toString)
            .collect(Collectors.joining(", "));

        System.out.printf("[%s]\r\n", numberString);
    }
}
