package step2.view;

import step2.domain.lotto.BuyLotto;
import step2.domain.lottoResult.LottoResult;
import step2.domain.lottoResult.LottoResults;
import step2.domain.lotto.Lottos;
import step2.domain.lottoResult.WinNumber;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "수동 %d장, 자동으로 %d장 구매했습니다.";
    private static final String WININNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS= "%d개 일치 (%d원)- %d개";
    private static final String SECOND_STATUS= "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String TOTAL_REVENUS= "총 수익률은 %.2f 입니다";


    public static void printPurchaseLotto(BuyLotto buyLotto) {
        System.out.println(String.format(PURCHASE_MESSAGE, buyLotto.getManualLottoQuantity(), buyLotto.getLottoQuantity()));
    }

    public static void printLottos(Lottos lottos) {
        lottos.stream().forEach(lotto ->
                System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public static void printLottoResult(LottoResults prizes) {
        System.out.println(WININNG_STATISTICS_MESSAGE);
        System.out.println(printLottoPrizes(prizes));
    }

    private static String printLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();

        for (LottoResult value : prizes.getLottoResults()) {
            String message = value.isWinNumber(WinNumber.SECOND) ? SECOND_STATUS : STATISTICS_STATUS;
            sb.append(String.format(message, value.getHitNumber(), value.getMoney(), value.getWinCount()));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printProfitStatus(int purchaseAmount, LottoResults prizes) {
        System.out.println(String.format(TOTAL_REVENUS, (double)prizes.getTotalMoney() / purchaseAmount));
    }
}
