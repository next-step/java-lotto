package lottogame.model.lotto.generator;

import static lottogame.controller.LottoStore.PER_LOTTO_PRICE;

import java.util.List;
import lottogame.model.lotto.Lottos;
import lottogame.model.price.LottoPurchasePrice;

public class TotallyLottosGenerator implements LottosGenerator{
    private final LottoPurchasePrice lottoPurchasePrice;
    private final List<String> manualLottos;

    public TotallyLottosGenerator(LottoPurchasePrice lottoPurchasePrice, List<String> manualLottos) {
        this.lottoPurchasePrice = lottoPurchasePrice;
        this.manualLottos = manualLottos;
    }

    @Override
    public Lottos generateLottos() {
        int totalLottoCount = this.lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE);
        int autoLottoCount = totalLottoCount - manualLottos.size();

        Lottos autoLottos = new AutoLottoGenerator(autoLottoCount).generateLottos();
        Lottos manualLottos = new ManualLottosGenerator(this.manualLottos).generateLottos();

        return autoLottos.merge(manualLottos);
    }
}
