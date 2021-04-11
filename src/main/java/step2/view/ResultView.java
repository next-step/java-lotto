package step2.view;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;

import java.util.List;
import java.util.Map;
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

    public static void prizeResult(PrizeMoney prizeMoney, ResultDto resultDto){
        Map<Integer, Integer> result = resultDto.getMatchCount();
        for (int i = PrizeMoney.getMatchCountForPrize(PrizeMoney.LOWEST_RANK_FOR_PRIZE); i <= PrizeMoney.getMatchCountForPrize(PrizeMoney.HIGHEST_RANK_FOR_PRIZE); i++) {
            System.out.println(i+"개 일치 ("+prizeMoney.getPrizeMoneyAsMatchCount(i)+"원)- "+result.get(i)+"개");
        }
    }
}
