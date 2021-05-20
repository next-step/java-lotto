package lotto.view;

import lotto.domain.LottoTickets;

public class PrintView {

    public void printLottoNumbers(LottoTickets lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        System.out.println(lottoTickets);
        System.out.println();
    }
}
