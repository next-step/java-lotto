package step2.view;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.utils.StringUtil;

import java.util.List;
import java.util.Map;

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
        System.out.println(StringUtil.splitStringFromList(lotto));
    }

    public static void prizeResult(PrizeMoney prizeMoney, ResultDto resultDto){
        Map<Integer, Integer> result = resultDto.getMatchCount();
        for (int i = PrizeMoney.getMatchCountForPrize(PrizeMoney.LOWEST_RANK_FOR_PRIZE); i <= PrizeMoney.getMatchCountForPrize(PrizeMoney.HIGHEST_RANK_FOR_PRIZE); i++) {
            System.out.println(i+"개 일치 ("+prizeMoney.getPrizeMoneyAsMatchCount(i)+"원)- "+result.get(i)+"개");
        }
        System.out.println("총 수익률은 "+resultDto.getEarningRatio()+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
