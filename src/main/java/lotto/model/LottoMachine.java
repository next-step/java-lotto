package lotto.model;

import lotto.model.generator.ManualLottoGenerator;
import lotto.model.generator.RandomLottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private ManualLottoGenerator manualLottoGenerator;
    private RandomLottoGenerator randomLottoGenerator;

    public LottoMachine(ManualLottoGenerator manualLottoGenerator, RandomLottoGenerator randomLottoGenerator) {
        this.manualLottoGenerator = manualLottoGenerator;
        this.randomLottoGenerator = randomLottoGenerator;
    }

    public static LottoMachine generate(PurchaseRequest purchaseRequest) {
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(purchaseRequest.getManualLottoInfo());
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(purchaseRequest.getMoney());
        return new LottoMachine(manualLottoGenerator, randomLottoGenerator);
    }

    public LottoTicket buy() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottoGenerator.generator());
        lottos.addAll(randomLottoGenerator.generator());
        return LottoTicket.of(lottos);
    }
}
