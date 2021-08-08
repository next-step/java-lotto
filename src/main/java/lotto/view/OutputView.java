package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.enumeration.LottoReward;

public class OutputView {

    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }


    public static OutputView getInstance() {
        return outputView;
    }


    public void showPlayerTicketNumbers(List<LottoTicket> playerTickets) {
        int playerTicketsCount = playerTickets.size();

        System.out.println(String.format("%d개를 구매 했습니다.", playerTicketsCount));

        for (LottoTicket ticket : playerTickets) {
            List<LottoNumber> value = ticket.value();
            List<Integer> collect = value.stream().map(e -> e.value()).collect(Collectors.toList());
            System.out.println(collect);
        }
    }

    public void showWinnerResult(LottoGameWinnerResult winnerResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out
            .println(getWinnerHitString(LottoReward.THREE_NUMBERS_MATCHED_REWARD, winnerResult));
        System.out
            .println(getWinnerHitString(LottoReward.FOUR_NUMBERS_MATCHED_REWARD, winnerResult));
        System.out
            .println(getWinnerHitString(LottoReward.FIVE_NUMBERS_MATCHED_REWARD, winnerResult));
        System.out
            .println(getWinnerHitString(LottoReward.SIX_NUMBERS_MATCHED_REWARD, winnerResult));
        System.out.println(String.format("총 수익률은 %s 입니다.", winnerResult.getProfitRate()));
    }

    private String getWinnerHitString(LottoReward reward, LottoGameWinnerResult winnerResult) {
        return String.format("%d개 일치 (%d)원 - %d 개",
            reward.getMatchedCount(),
            reward.getRewardMoney(),
            winnerResult.getHitCountByReward(reward));
    }
}
