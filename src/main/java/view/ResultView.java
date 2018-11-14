package view;

import domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottoNumbers(Lotto lotto) {
        for(List<Integer> paper : lotto.lottoPapers()) {
            System.out.println(paper);
        }
    }

    public static void printResult(List<Integer> values, int money) {
        double threeMatching = values.get(0);
        double fourMatching = values.get(1);
        double fiveMatching = values.get(2);
        double sixMatching = values.get(3);
        double ratio = ( threeMatching * 5000 +
                fourMatching * 50000 +
                fiveMatching * 1500000 +
                sixMatching * 2000000000) / (double)(money);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.print("3개 일치 (5000원)- ");
        System.out.println((int)threeMatching + "개");

        System.out.print("4개 일치 (50000원)- ");
        System.out.println((int)fourMatching + "개");

        System.out.print("5개 일치 (1500000원)- ");
        System.out.println((int)fiveMatching + "개");

        System.out.print("6개 일치 (2000000000원)- ");
        System.out.println((int)sixMatching + "개");
        System.out.println("총 수익률은 " + (int)(ratio*100)/100.0 + "입니다.");
    }
}
