package step2.lotto.automatic.view;

import step2.lotto.automatic.domain.LottoStatusEnum;

import java.util.List;
import java.util.Map;

public class OuterStep2View {

    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    private static final String GOOD_PRICE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
    private static final String BAD_PRICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OuterStep2View() {

    }

    public static void printBuyLotto(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public static void printAutoLottoNumbers(List<List<Integer>> paramList) {
        printDetailAutoNumbers(paramList.get(0));
        System.out.print(System.lineSeparator());

        for (int i = 1; i < paramList.size(); i++) {
            printDetailAutoNumbers(paramList.get(i));
            System.out.print(System.lineSeparator());
        }
    }

    private static void printDetailAutoNumbers(List<Integer> paramList) {
        System.out.print("[");
        System.out.print(paramList.get(0));

        for (int i = 1; i < paramList.size(); i++) {
            System.out.print(", " + paramList.get(i));
        }

        System.out.print("]");
    }

    public static void printLottoResult(Map<Integer, LottoStatusEnum> paramValue) {
        for (int i = MATCH_LOTTE_MAX_COUNT; i >= MATCH_LOTTE_MIN_COUNT; i--) {
            System.out.println(paramValue.get(i).getMessage()
                    + "("
                    + paramValue.get(i).getPrice()
                    + ") - "
                    + paramValue.get(i).getWinningCount());
        }

    }

    public static void printLottoProfitAmount(double paramValue){
        System.out.print("총 수익률은 " +  paramValue + "입니다.");

        if(paramValue > 1){
            System.out.print(GOOD_PRICE);
            return;
        }
        System.out.print(BAD_PRICE);
    }
}
