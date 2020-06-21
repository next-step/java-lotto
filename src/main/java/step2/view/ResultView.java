package step2.view;

import static step2.view.Messages.RESPONSE_PRICE_TEMPLATE;
import static step2.view.Messages.WINNING_STATISTIC_RESULT_LOSS_CASE;

import java.util.Arrays;
import step2.domain.LottoGameResultDto;
import step2.domain.LottoSheet;
import step2.domain.Prize;
import step2.domain.UserLotto;
import step2.domain.UserPrice;

public class ResultView {

    private final String winningStatisticTitle = "\n당첨 통계\n---------\n";
    private final String earningStatisticTemplate = "총 수익률은 %.2f입니다.";

    public void printPriceResult(UserPrice userPrice, int manualLottoCount) {
        System.out.printf(RESPONSE_PRICE_TEMPLATE, manualLottoCount,
            userPrice.getLottoCount(manualLottoCount));
    }

    public void printStatistic(LottoGameResultDto lottoGameResultDto) {
        System.out.print(winningStatisticTitle);
        for (Prize prize : Prize.winningValues()) {
            System.out.printf(ResultMessageTemplate.valueOf(prize.getGrade()).messageTemplate,
                prize.getCashPrize(),
                lottoGameResultDto.getPrizeCount(prize));
        }
        System.out.printf(earningStatisticTemplate, lottoGameResultDto.getEarningRate());
        printStatisticResult(lottoGameResultDto.getEarningRate());
    }

    public void printLottos(LottoSheet lottoSheet) {
        lottoSheet.getLottos().stream().forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(UserLotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    private enum ResultMessageTemplate {
        FIRST(1, "6개 일치 (%d원)- %d개\n"),
        SECOND(2, "5개 일치, 보너스 볼 일치(%d원) - %d개\n"),
        THIRD(3, "5개 일치 (%d원)- %d개\n"),
        FOURTH(4, "4개 일치 (%d원)- %d개\n"),
        FIFTH(5, "3개 일치 (%d원)- %d개\n");

        private int grade;
        private String messageTemplate;

        ResultMessageTemplate(int grade, String messageTemplate) {
            this.grade = grade;
            this.messageTemplate = messageTemplate;
        }

        public static ResultMessageTemplate valueOf(int grade) {
            ResultMessageTemplate[] resultMessageTemplates = values();
            return Arrays.stream(resultMessageTemplates)
                .filter(resultMessageTemplate -> resultMessageTemplate.grade == grade
                ).findAny().get();
        }
    }

    private void printStatisticResult(double earningRate) {
        if (earningRate < 1) {
            System.out.println(WINNING_STATISTIC_RESULT_LOSS_CASE);
        }
    }
}
