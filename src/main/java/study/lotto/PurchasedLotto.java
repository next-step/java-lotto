package study.lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    List<LottoPaper> lottoPapers;

    public PurchasedLotto(int lottoPapers) {
        List<LottoPaper> purchasedLottos = new ArrayList<>();
        while (purchasedLottos.size() < lottoPapers) {
            purchasedLottos.add(new LottoPaper());
        }
        this.lottoPapers = purchasedLottos;
    }

    public PurchasedLotto(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<LottoPaper> values() {
        return lottoPapers;
    }
}
