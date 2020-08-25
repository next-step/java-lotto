package step3.view;

import step3.domain.Lotto;
import step3.domain.WinningPrice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintResult {

    public static void printBuyQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoRandomList) {
        lottoRandomList.stream()
                .map(lotto -> lotto.getLottoNumber().stream()
                        .map(lottoNumber -> lottoNumber.getNumber())
                        .map(number -> number.toString())
                        .collect(Collectors.joining(", ", "[", "]")))
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
            String secondPriceExplain ="";
            if(key.getPrice() == 30000000) {
                secondPriceExplain = ", 보너스볼 일치";
            }
            System.out.println(key.getWinningNumbers() + "개 일치"+secondPriceExplain+ " (" + key.getPrice() + "원) - " + value + "개");
        }
    }

}
