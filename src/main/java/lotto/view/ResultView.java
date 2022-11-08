package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Reward;
import lotto.dto.LottosDto;

import java.util.Arrays;
import java.util.Map;

public class ResultView {

    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계";

    public static void lottoCountMessage(int value){
        System.out.println(value + BUY_LOTTO_MESSAGE);
    }

    public static void lottoTickets(LottosDto lottosDto){
        for (LottoTicket lottoTicket:  lottosDto.getLottosDto()){
            System.out.println(lottoTicket.toString());
        }
    }

    public static void winningStatics(){
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println("----------------");
    }

    public static void winningResult(Map<Reward,Integer> rewardMap) {
        Arrays.stream(Reward.values())
                .filter(reward -> reward != Reward.ZERO)
                .forEach(reward -> System.out.printf("%d개 일치 (%d원)- %d개\n", reward.getNumberMatch()
                        , reward.getRewordMoney(), rewardMap.getOrDefault(reward, 0)));
    }

    public static void lottoYieldCalculate(int yield){
        System.out.printf("총 수익률은 %.2f 입니다.", yield);
    }
}
