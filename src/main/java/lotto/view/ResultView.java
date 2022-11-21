package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Reward;
import lotto.dto.LottosDto;

import java.util.Arrays;
import java.util.Map;

public class ResultView {

    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계";
    private static final String RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String RESULT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String SIGN = "----------------";

    public static void lottoCountMessage(LottosDto lottosDto){
        System.out.println(lottosDto.getLottosDtoSize() + BUY_LOTTO_MESSAGE);
    }

    public static void lottoTickets(LottosDto lottosDto){
        for (LottoTicket lottoTicket:  lottosDto.getLottosDto()){
            System.out.println(lottoTicket.toString());
        }
    }

    public static void winningStatics(){
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(SIGN);
    }

    public static void winningResult(Map<Reward,Integer> rewardMap) {
        Arrays.stream(Reward.values())
                .filter(reward -> reward != Reward.ZERO)
                .forEach(reward -> System.out.printf(resultMessage(reward)
                        , reward.getNumberMatch()
                        , reward.getRewordMoney()
                        , rewardMap.getOrDefault(reward, 0)));
    }

    private static String resultMessage(Reward reward) {
        if(reward != Reward.SECOND_BONUS){
            return RESULT_MESSAGE;
        }
        return RESULT_BONUS_MESSAGE;
    }


    public static void lottoYield(double yield){
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
