package view;

import domain.LottoRank;
import domain.LottoResult;
import domain.LottoTickets;

public class OutputView {
    private static final String LOTTO_PURCHASE_QUANTITY_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "\n당첨 통계\n" + "---------\n";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String WINNING_COUNT_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
    private static final String TOTAL_REWARD_MESSAGE = "총 수익률은 %s입니다.";

    public static void lottoStatus(LottoTickets lottoTickets, LottoTickets manualLottos) {
        lottoQuantity(lottoTickets.lottoTicketCount(), manualLottos.lottoTicketCount());
        manualLottoTickets(manualLottos);
        lottoTickets(lottoTickets);
    }

    private static void lottoQuantity(int lottoTicketCount, int manualLottoCount) {
        System.out.println(String.format(LOTTO_PURCHASE_QUANTITY_MESSAGE, manualLottoCount, lottoTicketCount));
    }

    private static void manualLottoTickets(LottoTickets manualLottos) {
        manualLottos.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoTicket()));
    }

    private static void lottoTickets(final LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getLottoTicket()));
    }

    public static void LottoEnd(LottoResult lottoResult) {
        winning(lottoResult);
        totalRewardRatio(lottoResult);
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
        System.out.println(String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio()));
    }
}
