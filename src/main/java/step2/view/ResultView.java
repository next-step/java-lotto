package step2.view;

import step2.Constant;
import step2.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void showLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + Constant.BOUGHT_LOTTO_TICKETS);
        lottoTickets.forEach(e -> System.out.println(e.getNumbers()));
        System.out.println("");
    }

    public void showStatistics(Map<Integer, List<LottoTicket>> winningTickets){
        startStatistics();
        int index = Constant.COUNT_THREE;
        for(Map.Entry entry : winningTickets.entrySet()){
            showCountAndPrize(entry, index);
            index++;
        }
    }

    public void showProfit(double profit){
        System.out.println(Constant.PROFIT_RATIO + profit);
    }

    private void startStatistics(){
        System.out.println("");
        System.out.println(Constant.WINNING_STATISTICS);
        System.out.println(Constant.WINNING_STATISTICS_DIVISION);
    }

    private void showCountAndPrize(Map.Entry<Integer, List<LottoTicket>> entry, int index){
        System.out.print(index + Constant.UNIT_COUNT + Constant.BLANK + Constant.SAME + Constant.BLANK + Constant.PRIZE_WRAPPER(entry.getKey() + Constant.UNIT_PRIZE));
        System.out.println(Constant.DASH + Constant.BLANK + entry.getValue().size() + Constant.UNIT_COUNT);
    }
}
