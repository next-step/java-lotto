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
    private static final StringBuffer STRING_BUFFER = new StringBuffer();

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
        System.out.println(STRING_BUFFER.toString());
    }

    private static void winning(final LottoResult lottoResult) {
        STRING_BUFFER.append(LOTTO_WINNING_MESSAGE)
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.THREE.getWinningCount(), LottoRank.THREE.getReward(), lottoResult.getResult(LottoRank.THREE)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FOUR.getWinningCount(), LottoRank.FOUR.getReward(), lottoResult.getResult(LottoRank.FOUR)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIVE.getWinningCount(), LottoRank.FIVE.getReward(), lottoResult.getResult(LottoRank.FIVE)))
                .append(String.format(WINNING_COUNT_WITH_BONUS_MESSAGE, LottoRank.FIVE_WITH_BONUS.getWinningCount(), LottoRank.FIVE_WITH_BONUS.getReward(), lottoResult.getResult(LottoRank.FIVE_WITH_BONUS)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.SIX.getWinningCount(), LottoRank.SIX.getReward(), lottoResult.getResult(LottoRank.SIX)));
    }

    public static void totalRewardRatio(final LottoResult lottoResult) {
        STRING_BUFFER.append(String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio()));
    }
}
