package lotto.ui;

import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {
    private List<LottoTicket> lottoTicketList;

    public ResultView(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public void printResult() {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
                .forEach(lottoTicket -> lottoTicket.printLottoNumbers());
    }
}
