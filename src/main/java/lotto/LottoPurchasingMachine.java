package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchasingMachine {
    public static final int amount = 1000;

    public List<Lotto> buyLotto(int buyNumber) {
        int count = buyNumber / amount ;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
