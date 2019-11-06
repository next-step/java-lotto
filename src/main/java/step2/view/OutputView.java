package step2.view;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.PriceGroup;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String MATCH_RESULT_FORMAT = "%d개 일치 (%d)원 - %d 개";
    private static final int NEED_TO_SHOW = 3;
    private static final String RATE_RESULT = "총 수익률은 %.2f입니다.";
    private static final String BONUS_MATCH_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d)원 - %d 개";
    private static final String AMOUNT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public static int getPurchaseAmount(int money) {
        int amount = money / LOTTO_PRICE;
        System.out.println(amount + "개 구매하였습니다.");
        return amount;
    }

    public static void showBuyTickets(List<LottoTicket> lottoTickets, int manualAmount) {
        System.out.println(String.format(AMOUNT_FORMAT, manualAmount, lottoTickets.size() - manualAmount));
        lottoTickets.forEach(System.out::println);
    }

    public static void showResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        showBoard(lottoResult);
        showRate(lottoResult);
    }

    private static void showBoard(LottoResult lottoResult) {
        Map<PriceGroup, Integer> sortedResult = new EnumMap<>(lottoResult.getResult());
        sortedResult.forEach(OutputView::showEachBoard);
    }

    private static void showEachBoard(PriceGroup priceGroup, int amount) {
        if (priceGroup.getMatchAmount() < NEED_TO_SHOW) {
            return;
        }
        if (PriceGroup.FIVE_WITH_BONUS.equals(priceGroup)) {
            System.out.println(String.format(BONUS_MATCH_RESULT_FORMAT, priceGroup.getMatchAmount(), priceGroup.getPrice(), amount));
            return;
        }
        System.out.println(String.format(MATCH_RESULT_FORMAT, priceGroup.getMatchAmount(), priceGroup.getPrice(), amount));
    }

    private static void showRate(LottoResult lottoResult) {
        System.out.println(String.format(RATE_RESULT, lottoResult.getRate()));
    }
}
