package lotto.view;

import java.util.List;

public class LottoStatistics {

    private List<Integer> matchCounts;

    public LottoStatistics(List<Integer> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public void getStatistics() {
        System.out.println("3개 일치 (5000원)- " + getCount(3) + "개");
        System.out.println("4개 일치 (50000원)- " + getCount(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + getCount(5) + "개");
        System.out.println("6개 일치 (2000000000원)-" + getCount(6) + "개");
    }

    private int getCount(int count) {
        return (int) matchCounts.stream()
                .filter(i -> i == count)
                .count();
    }
}
