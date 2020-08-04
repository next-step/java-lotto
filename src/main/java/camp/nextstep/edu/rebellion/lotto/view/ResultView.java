package camp.nextstep.edu.rebellion.lotto.view;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;

import java.util.Arrays;
import java.util.Comparator;

public class ResultView {
    private static final String ENTER = "\n";
    private static final String AWARD_RESULT_FORMAT = "%2d개 일치 (%12d원) - %d개";
    private static final String PRIZE_RESULT_FORMAT = "총 수익률은 %.2f 입니다";

    private ResultView() {}

    public static void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(
                lottoNumber -> System.out.println(lottoNumber.getNumbers())
        );
    }

    public static void printWinningResult(LottoWinningResult result) {
        StringBuilder output = new StringBuilder();
        output.append(makeAwardTitle());
        output.append(makeAwardResult(result));
        System.out.println(output.toString());
    }

    public static void printReturnOfInvestment(int purchaseAmount, long totalReward) {
        System.out.println(String.format(PRIZE_RESULT_FORMAT, totalReward / (double) purchaseAmount));
    }

    private static String makeAwardTitle() {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계").append(ENTER);
        builder.append("----------").append(ENTER);
        return builder.toString();
    }

    private static String makeAwardResult(LottoWinningResult result) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(LottoAward.values())
                .filter(a -> a.getPrize() > LottoAward.LOSE.getPrize())
                .sorted(Comparator.comparing(LottoAward::getPrize))
                .forEach(a -> builder
                        .append(wrapAward(a, result.getAwardCount(a)))
                        .append(ENTER));
        return builder.toString();
    }

    private static String wrapAward(LottoAward award, int awardCount) {
        return String.format(AWARD_RESULT_FORMAT, award.getMatchCount(), award.getPrize(), awardCount);
    }
}
