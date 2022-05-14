package lotto.view;

import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class Output {
    private static final String LOTTO_CNT_INFO = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATICS = "당첨통계\n---------";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void printLottoCnt(int cnt){
        System.out.println(cnt+LOTTO_CNT_INFO);
    }

    public static void printLottoTicketList(List<LottoTicket> lottoTickets){
        for (LottoTicket lottoTicket: lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningStatics(Money buyPrice, LottoResult lottoResult){
        System.out.println(LOTTO_WINNING_STATICS);

        for (int i=3; i<= 6; i++){
            String s = getResult(lottoResult, i, false);
            System.out.println(s);
            if(i == 5){
                s = getResult(lottoResult, i, true);
                System.out.println(s);
            }
        }


        String profitRate = df.format(lottoResult.getProfitRate(buyPrice));
        System.out.println("총 수익룰은 "+profitRate+"입니다.");
    }

    private static String getResult(LottoResult lottoResult, int i, boolean bonus){

        String info = i+"개 일치";
        if(bonus){
            info+=", 보너스 볼 일치";
        }

        return info +
                "(" +
                Rank.of(i, bonus).getReward() +
                ")-" +
                lottoResult.getResult(i, bonus) +
                "개";
    }
}
