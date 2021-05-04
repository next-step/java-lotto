package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {

    public int countPurchasable(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<List> makeBunchOfLotto(int purchaseAmount) {
        List<List> bunchOfLotto = new ArrayList<>();
        int lottoCount = countPurchasable(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) {
            bunchOfLotto.add(Arrays.asList("1,2,3,4,5,6"));
        }
        return bunchOfLotto;
    }
}
