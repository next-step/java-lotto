package lotto.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries(int lottoCount) {
        lotteries = new ArrayList<>();

        for (int i=0; i<lottoCount; i++){
            lotteries.add(new Lottery(LottoCreator.createLotto()));
        }

    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
