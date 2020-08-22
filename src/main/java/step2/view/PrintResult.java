package step2.view;

import step2.domain.Lotto;
import step2.domain.MakeLottoFactory;

import java.util.List;

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
    public static void printResult(float result, String benefitOrNot) {
        System.out.println("총 수익률은 " + String.format("%.2f", result) + "입니다. " + benefitOrNot);
        System.out.println("결과는 " + result + "입니다.");
    }

}
