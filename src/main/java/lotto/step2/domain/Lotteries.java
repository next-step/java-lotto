package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotteries {

    private List<Lotto> lotteries = new ArrayList<>();

    public Lotteries(int orderCount) {
        createLotteries(orderCount);
    }
    // 테스트 편의 생성자
    public Lotteries(Lotto ... lotto) {
        this.lotteries = Arrays.asList(lotto);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    private void createLotteries(int orderCount) {
        for (int i = 0; i < orderCount; i++) {
            lotteries.add(new Lotto());
        }
    }

}
