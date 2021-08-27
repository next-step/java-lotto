package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPapers {

    private List<LottoPaper> lottoPapers;

    private LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public static LottoPapers create(Money money) {
        List<LottoPaper> lottoPapers = new ArrayList<>();
        RandomNumber numberStragey = new LottoNumberStragey();
        for (int count = 0; count < money.purchaseLottoCount(); count++) {
            lottoPapers.add(new LottoPaper(numberStragey));
        }
        return new LottoPapers(lottoPapers);
    }

    public List<LottoPaper> getLottoPapers() {
        return lottoPapers;
    }
}
