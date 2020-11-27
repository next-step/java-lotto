package step4.lotto.view;

import step4.lotto.domain.LottoStatusEnum;
import step4.lotto.domain.numbers.LottoTicket;

import java.util.*;

public class OuterLottoView {

    private static final int MATCH_LOTTE_MAX_COUNT = 5;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    private static final String GOOD_PRICE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
    private static final String BAD_PRICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OuterLottoView() {

    }

    public static void printBuyLotto(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public static void printAutoLottoNumbers(Set<LottoTicket> paramHashSet) {
        Iterator iter = paramHashSet.iterator();

        System.out.print(System.lineSeparator());
        while(iter.hasNext()) {
            printDetailAutoNumbers((LottoTicket)iter.next());
            System.out.print(System.lineSeparator());
        }
    }

    private static void printDetailAutoNumbers(LottoTicket lottoTicket) {
        SortedSet<Integer> lottoSortedSet = lottoTicket.getLottoTicket();
        StringBuffer sb = new StringBuffer();
        int count = 0;
        Iterator iter = lottoSortedSet.iterator();

        sb.append("[");
        while(iter.hasNext()) {
            if(count == 0){
                sb.append(iter.next());
                count++;
            }
            sb.append(", " +iter.next());
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

    public static void printLottoProfitAmount(double paramValue) {
        double viewValue = Math.floor(paramValue * (double) 100) / (double) 100;

        System.out.print("총 수익률은 " + viewValue + "입니다.");

        if (paramValue > 1) {
            System.out.println(GOOD_PRICE);
            return;
        }
        System.out.println(BAD_PRICE);
    }
}
