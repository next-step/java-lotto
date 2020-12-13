package lotto;

public class OutputView {
    private static final String LOTTO_PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "\n당첨 통계\n" + "---------\n";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String TOTAL_REWARD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final StringBuffer STRING_BUFFER = new StringBuffer();

    public static void lottoQuantity(final int quantity) {
        System.out.println(String.format(LOTTO_PURCHASE_QUANTITY_MESSAGE, quantity));
    }

    public static void lottoTickets(final LottoTickets lottoTickets) {
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
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.THREE.getWinningCount(), LottoRank.THREE.reward(), lottoResult.getResult(LottoRank.THREE)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FOUR.getWinningCount(), LottoRank.FOUR.reward(), lottoResult.getResult(LottoRank.FOUR)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIVE.getWinningCount(), LottoRank.FIVE.reward(), lottoResult.getResult(LottoRank.FIVE)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.SIX.getWinningCount(), LottoRank.SIX.reward(), lottoResult.getResult(LottoRank.SIX)));
    }

    public static void totalRewardRatio(final LottoResult lottoResult) {
        STRING_BUFFER.append(String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio()));
    }
}
