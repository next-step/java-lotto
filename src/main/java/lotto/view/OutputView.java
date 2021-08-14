package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBundle;
import lotto.enumeration.LottoReward;

public class OutputView {

    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }


    public static OutputView getInstance() {
        return outputView;
    }


    public void showPlayerTicketNumbers(LottoTicketBundle ticketBundle) {
        showHowManyAutoAndManual(ticketBundle);
        showAllLottoTicketNumbers(ticketBundle);
    }


    private void showAllLottoTicketNumbers(LottoTicketBundle ticketBundle) {
        List<LottoTicket> allLottoTickets = ticketBundle.getAllLottoTickets();
        for (LottoTicket ticket : allLottoTickets) {
            List<LottoNumber> lottoNumbers = ticket.value();
            List<Integer> lottoIntegerNumbers = lottoNumbers.stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());

            System.out.println(lottoIntegerNumbers);
        }
    }

    private void showHowManyAutoAndManual(LottoTicketBundle ticketBundle) {
        String format = String.format("%수동으로 %d장, 자동으로 %d장을 구매 했습니다.",
            ticketBundle.getManualTicketSize(),
            ticketBundle.getAutoTicketSize());

        System.out.println(format);
    }

    public void showWinnerResult(LottoGameWinnerResult winnerResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");

        LottoReward.stream()
            .filter(e -> !e.equals(LottoReward.NO_MATCHED))
            .forEach(e -> System.out.println(getWinnerHitString(e, winnerResult)));

        System.out.println(getProfitRateString(winnerResult));
    }

    private String getProfitRateString(LottoGameWinnerResult winnerResult) {
        return String.format("총 수익률은 %s 입니다.", winnerResult.getProfitRate());
    }

    private String getWinnerHitString(LottoReward reward, LottoGameWinnerResult winnerResult) {
        String hitStringFormat = decideHitStringFormat(reward);

        return String.format(hitStringFormat,
            reward.getMatchedNumberCount(),
            reward.getRewardMoney(),
            winnerResult.getHitCountByReward(reward));
    }

    private String decideHitStringFormat(LottoReward reward) {
        String defaultResultFormat = "%d개 일치 (%d)원 - %d 개";

        if (reward.equals(LottoReward.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED)) {
            return "%d개 일치, 보너스 볼 일치(%d)원 - %d 개";
        }
        return defaultResultFormat;
    }
}
