package step2.lotto.automatic.view;

import step2.lotto.automatic.domain.LottoStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OuterLottoView {

    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    private static final String GOOD_PRICE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
    private static final String BAD_PRICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OuterLottoView() {

    }

    public static void printBuyLotto(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public static void printAutoLottoNumbers(Set<List<Integer>> paramHashSet, int count) {
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(paramHashSet);
        printDetailAutoNumbers(list.get(0));
        System.out.print(System.lineSeparator());

        for (int i = 1; i < count; i++) {
            printDetailAutoNumbers(list.get(i));
            System.out.print(System.lineSeparator());
        }
    }

    private static void printDetailAutoNumbers(List<Integer> paramList) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        sb.append(paramList.get(0));
        for (int i = 1; i < paramList.size(); i++) {
            sb.append(", " + paramList.get(i));
        }
        sb.append("]");
        System.out.print(sb);
    }

    public static void printLottoResult() {
        StringBuffer sb = new StringBuffer();
        LottoStatusEnum lottoEnum;

        for (int i = MATCH_LOTTE_MAX_COUNT; i >= MATCH_LOTTE_MIN_COUNT; i--) {
            lottoEnum = LottoStatusEnum.findByCount(i);
            sb.append(lottoEnum.getMessage()
                    + "("
                    + lottoEnum.getPrice()
                    + ") - "
                    + lottoEnum.getWinningCount()
            );
            sb.append("\n");
        }
        System.out.println(sb);
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
