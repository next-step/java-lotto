package camp.nextstep.edu.rebellion.lotto.view;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoNumber;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoTicket;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ResultView {
    private static final String ENTER = "\n";
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String LOTTO_LEFT_BRACE = "[";
    private static final String LOTTO_RIGHT_BRACE = "]";
    private static final String LOTTO_AWARD_RESULT_FORMAT = "%2d개 일치 (%12d원) - %d개";
    private static final String LOTTO_BONUS_AWARD_RESULT_FORMAT = "%2d개 일치, 보너스 볼 일치(%12d원) - %d개";
    private static final String LOTTO_ROI_FORMAT = "총 수익률은 %.2f 입니다";

    private ResultView() {}

    public static void printLottoTicket(LottoTicket lottoTicket) {
        StringBuilder output = new StringBuilder();
        lottoTicket.getLottoNumbers()
                .forEach(lotto -> output
                        .append(LOTTO_LEFT_BRACE)
                        .append(makePrintingLotto(lotto))
                        .append(LOTTO_RIGHT_BRACE)
                        .append(ENTER));
        System.out.println(output.toString());
    }

    private static String makePrintingLotto(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
    }

    public static void printWinningResult(LottoWinningResult result) {
        StringBuilder output = new StringBuilder();
        output.append(makeAwardTitle());
        output.append(makeAwardResult(result));
        output.append(makeReturnOfInvestment(result.getReturnOfInvestment()));
        System.out.println(output.toString());
    }

    private static String makeAwardTitle() {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계").append(ENTER);
        builder.append("----------").append(ENTER);
        return builder.toString();
    }

    private static String makeReturnOfInvestment(double roi) {
        return String.format(LOTTO_ROI_FORMAT, roi);
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
        return String.format(pickAwardFormat(award),
                award.getCountOfMatch(), award.getPrize(), awardCount);
    }

    private static String pickAwardFormat(LottoAward award) {
        return LottoAward.SECOND == award ?
                LOTTO_BONUS_AWARD_RESULT_FORMAT :
                LOTTO_AWARD_RESULT_FORMAT;
    }
}
