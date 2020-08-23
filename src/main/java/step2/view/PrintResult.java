package step2.view;

import step2.domain.Lotto;
import step2.domain.MakeLottoFactory;
import step2.domain.WinningPrice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintResult {

    public static void printBuyQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoRandomList) {
        lottoRandomList.stream()
                .map(lotto -> lotto.getLottoValue())
                .forEach(System.out::println);
    }

    //총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    public static void printResult(float result, boolean isBenefit) {
        String bentfitOrNot = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        if (isBenefit) {
            bentfitOrNot = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }

        System.out.print("총 수익률은 " + String.format("%.2f", result) + "입니다. ");
        System.out.println(bentfitOrNot);
    }

    public static void printLottoMap(Map<WinningPrice, Integer> winningPriceIntegerMap) {
        Iterator<WinningPrice> mapIter = winningPriceIntegerMap.keySet().iterator();
        for (WinningPrice key : winningPriceIntegerMap.keySet()) {
            int value = winningPriceIntegerMap.get(key);
            System.out.println(key.getWinningNumbers() + "개 일치(" + key.getPrice() + "원) - " + value + "개");
        }
    }

}
