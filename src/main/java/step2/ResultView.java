package step2;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print(lotto.toString());
            System.out.println();
        }
    }

    public void printCollectMap(Map collectMap) {
        System.out.println("당청통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + collectMap.getOrDefault(3,0));
        System.out.println("4개 일치 (50000원)- " + collectMap.getOrDefault(4,0));
        System.out.println("5개 일치 (1500000원)- " + collectMap.getOrDefault(5,0));
        System.out.println("6개 일치 (2000000000원)- " + collectMap.getOrDefault(6,0));
    }
}
