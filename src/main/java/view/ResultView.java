package view;

import domain.Lottos;

import static domain.LottoStandard.PROFIT_STANDARD;

public class ResultView {
    private final String DISPLAY_QUANTITY = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private final String RESULT_STATISTIC = "당첨 통계";
    private final String HORIZONTAL = "---------";
    private final String STATISTIC_MENTION = "%d개 일치 (%d원)- %d개";
    private final String STATISTIC_MENTION_SECOND = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private final String PROFIT_MENTION = "총 수익률은 %.2f입니다.";
    private final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void displayLottoQuantity(int manualQuantity, int autoQuantity) {
        System.out.println();
        System.out.println(String.format(DISPLAY_QUANTITY, manualQuantity, autoQuantity));
    }

    public void displayLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getLottoNumbers().getNumbers()));
        System.out.println();
    }

    public void displayResultMention() {
        System.out.println();
        System.out.println(RESULT_STATISTIC);
        System.out.println(HORIZONTAL);
    }

    public void displaySecondPrize(int matchNumber, int money, int matchCount) {
        System.out.println(String.format(STATISTIC_MENTION_SECOND,
                matchNumber,
                money,
                matchCount));
    }

    public void displayPrizeExceptSecond(int matchNumber, int money, int matchCount) {
        System.out.println(String.format(STATISTIC_MENTION,
                matchNumber,
                money,
                matchCount));
    }

    public void displayProfit(double profit) {
        System.out.print(String.format(PROFIT_MENTION, profit));
        if (profit < PROFIT_STANDARD.getStandardNumber()) {
            System.out.println(LOSS);
        }
    }
}
