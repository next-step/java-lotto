package study.lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    List<LottoPaper> lottoPapers;

    public PurchasedLottos(int lottoPapers) {
        List<LottoPaper> purchasedLottos = new ArrayList<>();
        while (purchasedLottos.size() < lottoPapers) {
            LottoPaper purchaseLotto = new LottoPaper();
            purchasedLottos.add(purchaseLotto);
        }
        this.lottoPapers = purchasedLottos;
    }

    public PurchasedLottos(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<LottoPaper> values() {
        return lottoPapers;
    }
}
