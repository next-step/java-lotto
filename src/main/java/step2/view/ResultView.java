package step2.view;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.utils.StringUtil;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void showMyLottoNumbers(LottoTickets lottoTickets){
        List<LottoTicket> lottoList = lottoTickets.getLottoTickets();
        System.out.println(lottoTickets.getTheNumberOfLottoTickets()+"장을 구매했습니다.");
        for (LottoTicket lottoTicket : lottoList) {
            List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
            System.out.println(StringUtil.splitStringFromList(lottoNumbers));
        }
        System.out.println();
    }

    public static void showResult(Map<Integer, Integer> result, PrizeMoney prizeMoney){
        System.out.println("당첨 통계\n---------");

        for (int i = PrizeMoney.MATCH_NUMBERS_NEED_TO_FOURTH_GRADE; i <= PrizeMoney.MATCH_NUMBERS_NEED_TO_FIRST_GRADE; i++) {
            System.out.println(i+"개 일치 ("+prizeMoney.getPrizeMoney(i)+") - "+result.get(i));
        }
    }

    public static void showEarningRatio(double earningRatio){
        System.out.printf("총 수익률은 %.2f입니다. (1을 기준으로 이상이면 수익, 이하면 손실입니다.)",earningRatio);
    }
}
