package lotto.view;

import lotto.common.type.WinnerRank;
import lotto.domain.Lottos;
import lotto.domain.RewardStatistics;
import lotto.input.ManualLottoInput;
import lotto.input.LottoTicketInput;

public class ResultView {

    public static final String RESULT_BANNER = "당첨 통계\n---------";
    public static final String LOTTO_CONDITION_PRINT_FORMAT = "%d개 일치";
    public static final String LOTTO_BONUS_PRINT_FORMAT = ", 보너스 볼 일치";
    public static final String REWARD_PRINT_FORMAT = " (%d원)";
    public static final String REWARD_COUNT_PRINT_FORMAT = "- %d개";
    public static final String RATIO_PRINT_FORMAT = "총 수익률은 %.2f입니다.";

    public void printLottoCount(LottoTicketInput lottoTicketInput, ManualLottoInput manualLottoInput){
        int totalLottoCount = lottoTicketInput.getTicketCount();
        int manualLottoCount = manualLottoInput.getInputSize();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoCount, totalLottoCount - manualLottoCount);
        System.out.println();
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(System.out::println);
    }

    public void printAllResult(RewardStatistics rewardStatistics, double profitRatio){
        System.out.println(RESULT_BANNER);
        rewardStatistics.getWinnerCount().forEach(this::printEachResult);
        System.out.printf(RATIO_PRINT_FORMAT, profitRatio);
    }

    public void printEachResult(WinnerRank winnerRank, int rewardCount){
        System.out.printf(LOTTO_CONDITION_PRINT_FORMAT, winnerRank.getCorrectNumberCount());
        if(winnerRank.isSecond()){
            System.out.print(LOTTO_BONUS_PRINT_FORMAT);
        }
        System.out.printf(REWARD_PRINT_FORMAT, winnerRank.getReward());
        System.out.printf(REWARD_COUNT_PRINT_FORMAT, rewardCount);
        System.out.println();
    }
}
