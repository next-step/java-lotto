package lotto.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_TITLE_MSG = "당첨 통계";
    private static final String RESULT_DELIMITER_MSG = "---------";

    private static final int[] PRIZE_REWARDS = {
        5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
    };
    public void printResult() {
        System.out.println(RESULT_TITLE_MSG);
        System.out.println(RESULT_DELIMITER_MSG);

    }
    public void printResult(List<Integer> result) {
        for(int i=0; i<result.size(); i++){
            // TODO : if i == 3, it is match 5 and bonus.
            if(i==3){
                System.out.printf("%d개 일치 (%d원) - %d개\n",i+3,PRIZE_REWARDS[i],result.get(i));
            }
            else {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",i+3,PRIZE_REWARDS[i],result.get(i));
            }
        }
    }
    public void printRevenue(Double resRevenue) {
        System.out.printf("총 수익률은 %f 입니다.", resRevenue);
    }

}
