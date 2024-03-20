package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PER_MONEY = 1_000;

    private LottoMachine() {
    }

    public static LottoPaper purchase(Money money, List<Lotto> manualLottos) {
        int maxQuantity = money.maxQuantity();
        int automaticQuantity = maxQuantity - manualLottos.size();
        List<Lotto> automaticLottos = createAutomaticLottos(automaticQuantity);

        return new LottoPaper(automaticLottos, manualLottos);
    }

    private static List<Lotto> createAutomaticLottos(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumberFactory.selectRandomLottoNumbers()));
        }

        return result;
    }

}
