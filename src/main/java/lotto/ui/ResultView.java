package lotto.ui;

import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private List<LottoTicket> lottoTicketList;
    private Map<Integer, Integer> lottoRank = new HashMap<>();

    public ResultView(List<LottoTicket> lottoTicketList) {
        initLottoRank();
        this.lottoTicketList = lottoTicketList;
    }

    public void printLottoTicketList() {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
                .forEach(lottoTicket -> lottoTicket.printLottoNumbers());

        System.out.println();
    }

    private List<Integer> convertList(String winningNumber) {
        return lottoTicketList.stream()
                .map(lottoTicket -> lottoTicket.matchWinningNumbers(winningNumber))
                .collect(Collectors.toList());
    }

    private void initLottoRank() {
        int[] lottoRankNumber = {3, 4, 5, 6};
        int[] lottoRankMoney = {5000, 50000, 1500000, 2000000000};

        for (int i = 0; i < lottoRankMoney.length; i++) {
            lottoRank.put(lottoRankNumber[i], lottoRankMoney[i]);
        }
    }
}
