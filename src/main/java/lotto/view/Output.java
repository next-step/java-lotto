package lotto.view;

import lotto.model.LottoResult;
import lotto.model.LottoTicket;

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

    public static void printWinningStatics(int buyPrice, LottoResult lottoResult){
        System.out.println(LOTTO_WINNING_STATICS);

        for (int i=3; i<= 6; i++){
            String s = i +
                    "개 일치 (" +
                    lottoResult.getPrice(i) +
                    ")-" +
                    lottoResult.getResult(i) +
                    "개";
            System.out.println(s);
        }


        String profitRate = df.format(lottoResult.getProfitRate(buyPrice));
        System.out.println("총 수익룰은 "+profitRate+"입니다.");
    }
}
