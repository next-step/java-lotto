package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    List<LottoPaper> lottoBundle;

    public LottoBundle() {}

    public LottoBundle(int quantity) {
        lottoBundle = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoBundle.add(new LottoPaper());
        }
    }

    public int getSize() {
        return lottoBundle.size();
    }

    public LottoPaper getLottoPaper(int index) {
        return lottoBundle.get(index);
    }
}
