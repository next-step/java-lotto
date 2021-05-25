package view;

import domain.LottoRank;
import domain.LottoResult;
import domain.LottoTickets;

public class OutputView {
    private static final String LOTTO_PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "\n당첨 통계\n" + "---------\n";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String WINNING_COUNT_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
    private static final String TOTAL_REWARD_MESSAGE = "총 수익률은 %s입니다.";
    private static String RESULT_MESSAGE = "";

    public static void lottoStatus(LottoTickets lottoTickets) {
        lottoQuantity(lottoTickets.lottoTicketCount());
        lottoTickets(lottoTickets);
    }

    private static void lottoQuantity(final int quantity) {
        System.out.println(String.format(LOTTO_PURCHASE_QUANTITY_MESSAGE, quantity));
    }

    private static void lottoTickets(final LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoTicket()));
    }

    public static void LottoEnd(LottoResult lottoResult) {
        winning(lottoResult);
        totalRewardRatio(lottoResult);
        System.out.println(RESULT_MESSAGE);
    }

    private static void winning(final LottoResult lottoResult) {
        System.out.print(LOTTO_WINNING_MESSAGE);
        System.out.print(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIRTH.getWinningCount(), LottoRank.FIRTH.getReward(), lottoResult.getResult(LottoRank.FIRTH)));
        System.out.print(String.format(WINNING_COUNT_MESSAGE, LottoRank.FOURTH.getWinningCount(), LottoRank.FOURTH.getReward(), lottoResult.getResult(LottoRank.FOURTH)));
        System.out.print(String.format(WINNING_COUNT_MESSAGE, LottoRank.THIRD.getWinningCount(), LottoRank.THIRD.getReward(), lottoResult.getResult(LottoRank.THIRD)));
        System.out.print(String.format(WINNING_COUNT_WITH_BONUS_MESSAGE, LottoRank.SECOND.getWinningCount(), LottoRank.SECOND.getReward(), lottoResult.getResult(LottoRank.SECOND)));
        System.out.print(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIRST.getWinningCount(), LottoRank.FIRST.getReward(), lottoResult.getResult(LottoRank.FIRST)));
    }

    public static void totalRewardRatio(final LottoResult lottoResult) {
        RESULT_MESSAGE = String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio());
    }
}
