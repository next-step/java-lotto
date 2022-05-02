package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Revenue {
    private int lotto1st;
    private int lotto2ed;
    private int lotto3rd;
    private int lotto4th;
    private int price;
    private int revenue;

    public Revenue(List<List<Integer>> lottos, int price) {
        lotto1st = findByRanking(lottos, 6);
        lotto2ed = findByRanking(lottos, 5);
        lotto3rd = findByRanking(lottos, 4);
        lotto4th = findByRanking(lottos, 3);
        this.price = price;
        calculation();

    }

    private int findByRanking(List<List<Integer>> lottos, int count) {
        return lottos.stream()
                .filter(lotto -> lotto.size() == count)
                .collect(Collectors.toList()).size();
    }

    private void calculation() {
        revenue += lotto1st * 2000000000;
        revenue += lotto2ed * 1500000;
        revenue += lotto3rd * 50000;
        revenue += lotto4th * 5000;
    }

    @Override
    public String toString() {
        return "당첨 통계" +
                "\n 3개 일치 (5000원)- " + (lotto4th) + "개" +
                "\n 4개 일치 (50000원)- " + (lotto3rd) + "개" +
                "\n 5개 일치 (1500000원)- " + (lotto2ed) + "개" +
                "\n 6개 일치 (2000000000원)- " + (lotto1st) + "개" +
                ", 총 수익률은 = " + (Double.valueOf(revenue) / Double.valueOf(price)) +
                '}';
    }
}
