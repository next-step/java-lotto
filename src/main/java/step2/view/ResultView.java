package step2.view;

import step2.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printMyLottoTickets(List<LottoTicket> lottoTickets, int numberOfLottoTickets){
        System.out.println(numberOfLottoTickets+"개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            printLottoSingleTicket(lottoTicket.getNumbers());
        }
    }

    public static void printLottoPrizeNumber(){
        LottoTicket lotto = new LottoTicket();
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> magicNumber = lotto.getNumbers();
        printLottoSingleTicket(magicNumber);
    }

    private static void printLottoSingleTicket(List<Integer> lotto){
        String result = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("["+result+"]");
    }
}
