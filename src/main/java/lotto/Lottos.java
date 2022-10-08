package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;

    public Lottos(int amount) {
        int n = amount/ LOTTO_PRICE;
        this.lottoList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            this.lottoList.add(new Lotto());
        }
    }

    public int lottosSize() {
        return this.lottoList.size();
    }
}
