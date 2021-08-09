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
            List<LottoNumber> lottoNumbers = ticket.value();
            List<Integer> lottoIntegerNumbers = lottoNumbers.stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());

            System.out.println(lottoIntegerNumbers);
        }
    }

    public void showWinnerResult(LottoGameWinnerResult winnerResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        LottoReward.stream()
            .filter(e -> !e.equals(LottoReward.NO_REWARD))
            .forEach(e -> System.out.println(getWinnerHitString(e, winnerResult)));

        System.out.println(getProfitRateString(winnerResult));
    }

    private String getProfitRateString(LottoGameWinnerResult winnerResult) {
        return String.format("총 수익률은 %s 입니다.", winnerResult.getProfitRate());
    }

    private String getWinnerHitString(LottoReward reward, LottoGameWinnerResult winnerResult) {
        return String.format("%d개 일치 (%d)원 - %d 개",
            reward.getMatchedCount(),
            reward.getRewardMoney(),
            winnerResult.getHitCountByReward(reward));
    }
}
