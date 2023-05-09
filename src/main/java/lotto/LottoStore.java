package lotto;

import java.util.*;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLotto(int price) {
        List<Lotto> result = new ArrayList<>();
        int nums = price / LOTTO_PRICE;
        for (int i = 0; i < nums; i++) {
            result.add(new Lotto());
        }
        return result;
    }
}
