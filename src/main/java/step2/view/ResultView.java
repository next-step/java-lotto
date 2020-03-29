package step2.view;

import step2.domain.BuyInfo;
import step2.domain.ResultInfo;

import java.util.Iterator;

public class ResultView {
    public static void printBuyList(BuyInfo buyInfo) {
        System.out.println(buyInfo.getBuyLottoCount() + "개를 구매했습니다.");
        Iterator iterator = buyInfo.getBuyLottoList().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printResult(ResultInfo resultInfo) {
        System.out.println("당첨통계");
        System.out.println("--------");

        System.out.println(resultInfo.getResultSentence());
    }
}
