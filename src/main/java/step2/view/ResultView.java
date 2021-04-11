package step2.view;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printMyLottoTickets(LottoTickets lottoTickets){
        List<LottoTicket> myLottoTickets = lottoTickets.getLottoTickets();
        int numberOfLottoTickets = lottoTickets.getNumberOfLottoTickets();
        System.out.println(numberOfLottoTickets+"장을 구매했습니다.");
        for (LottoTicket singleLottoTicket : myLottoTickets) {
            printLottoSingleTicket(singleLottoTicket.getNumbers());
        }
    }

    private static void printLottoSingleTicket(List<Integer> lotto){
        String result = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("["+result+"]");
    }
}
