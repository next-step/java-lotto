package step3.view;

import step3.domain.*;

import java.util.Iterator;

public class OutputView {
    private static final String Rank_BASIC = "%d개 일치(%s)원 - %d개";
    private static final String Rank_SPECIAL = "%d개 일치, 보너스 볼 일치(%s)원 - %d개";
    private static final String RESULT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String MANUAL = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public OutputView(BuyInfo buyInfo) {
        printBuyList(buyInfo);
    }

    public void printBuyList(BuyInfo buyInfo) {
        System.out.println(String.format(MANUAL,buyInfo.getManualCount(), buyInfo.getAutoCount()));
        Iterator iterator = buyInfo.printList().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printResult(ResultInfo resultInfo) {
        System.out.println("당첨 통계 \n================\n");
        System.out.println(String.format(Rank_BASIC, RankInformation.EQUALS_COUNT_3.getCount(),
                RankInformation.EQUALS_COUNT_3.getPrice().toString(), resultInfo.match(RankInformation.EQUALS_COUNT_3)));
        System.out.println(String.format(Rank_BASIC, RankInformation.EQUALS_COUNT_4.getCount(),
                RankInformation.EQUALS_COUNT_4.getPrice().toString(), resultInfo.match(RankInformation.EQUALS_COUNT_4)));
        System.out.println(String.format(Rank_BASIC, RankInformation.EQUALS_COUNT_5.getCount(),
                RankInformation.EQUALS_COUNT_5.getPrice().toString(), resultInfo.match(RankInformation.EQUALS_COUNT_5)));
        System.out.println(String.format(Rank_SPECIAL, RankInformation.EQUALS_COUNT_BONUS_5.getCount(),
                RankInformation.EQUALS_COUNT_BONUS_5.getPrice().toString(), resultInfo.match(RankInformation.EQUALS_COUNT_BONUS_5)));
        System.out.println(String.format(Rank_BASIC, RankInformation.EQUALS_COUNT_6.getCount(),
                RankInformation.EQUALS_COUNT_6.getPrice().toString(), resultInfo.match(RankInformation.EQUALS_COUNT_6)));
        System.out.println(String.format(RESULT, resultInfo.getRate().toString()));
    }

}
