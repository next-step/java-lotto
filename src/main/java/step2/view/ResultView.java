package step2.view;

import java.util.List;

public class ResultView {

    public static void printBuyLottos(List<Object> lottos) {
        for (Object lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Object lotto) {
        System.out.println(lotto.toString());
    }

    public static void printResult(Object result) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        int fourthCount = 0;
        int thirdCount = 0;
        int secondCount = 0;
        int firstCount = 0;

        System.out.printf("3개 일치 (5000원)- %d개", fourthCount);
        System.out.printf("4개 일치 (50000원)- %d개", thirdCount);
        System.out.printf("5개 일치 (1500000원)- %d개", secondCount);
        System.out.printf("6개 일치 (2000000000원)- %d개", firstCount);
    }
}
