package step2.view;

import step2.domain.BuyInfo;
import step2.domain.WinInformation;

import java.util.Iterator;

public class ResultView {
    public static void printBuyList(BuyInfo buyInfo) {
        System.out.println(buyInfo.getBuyLottoCount() + "개를 구매했습니다.");

        Iterator iterator = buyInfo.getBuyLottoList().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static void printResult(BuyInfo buyInfo) {
        System.out.println("당첨통계");
        System.out.println("--------");

        System.out.println(WinInformation.EQUALS_COUNT_3.getCount() + "개 일치 ("+WinInformation.EQUALS_COUNT_3.getPrice() + "원) - " + buyInfo.match(WinInformation.EQUALS_COUNT_3.getCount()));
        System.out.println(WinInformation.EQUALS_COUNT_4.getCount() + "개 일치 ("+WinInformation.EQUALS_COUNT_4.getPrice() + "원) - " + buyInfo.match(WinInformation.EQUALS_COUNT_4.getCount()));
        System.out.println(WinInformation.EQUALS_COUNT_5.getCount() + "개 일치 ("+WinInformation.EQUALS_COUNT_5.getPrice() + "원) - " + buyInfo.match(WinInformation.EQUALS_COUNT_5.getCount()));
        System.out.println(WinInformation.EQUALS_COUNT_6.getCount() + "개 일치 ("+WinInformation.EQUALS_COUNT_6.getPrice() + "원) - " + buyInfo.match(WinInformation.EQUALS_COUNT_6.getCount()));

    }
}
