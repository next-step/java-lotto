package lotto_auto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<List<Integer>> lottoTotalNumberList;
    int budget;

    public Lotto() {
    }

    public Lotto(int budget) {
        this.budget = budget;
    }

    public void getLottoNumber() {
        lottoTotalNumberList = new ArrayList<>();
        for (int j = 0; j < budget / 1000; j++) {
            lottoTotalNumberList.add(RandomNumberGen.getRandomNumberList());
        }
    }

}
