package lotto.model;

import java.util.List;

public class LottosBundleGenerator implements LottosGenerator {
    private final Money money;
    private final List<String> manualLottoText;

    public LottosBundleGenerator(Money money, List<String> manualLottoText) {
        this.money = money;
        this.manualLottoText = manualLottoText;
    }

    @Override
    public Lottos generate() {
        Count manualCounts = new Count(manualLottoText.size());
        Count autoCounts = money.countBuyableLottoTickets().subtract(manualCounts);
        Lottos manuals = new ManualLottosGenerator(manualLottoText).generate();
        Lottos autos = new AutoLottosGenerator(autoCounts).generate();
        return Lottos.of(manuals, autos);
    }
}
