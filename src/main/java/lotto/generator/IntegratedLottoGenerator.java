package lotto.generator;

import lotto.LottoOrder;
import lotto.Lottos;

public class IntegratedLottoGenerator implements LottoGenerator {
    private int numberOfAutoLottos;
    private ManualLottoGenerator manualLottoGenerator;

    public IntegratedLottoGenerator(LottoOrder lottoOrder) {
        this.manualLottoGenerator = new ManualLottoGenerator(lottoOrder.getManualLottos());
        this.numberOfAutoLottos = lottoOrder.getNumberOfAutoLottos();
    }

    @Override
    public Lottos generateLottos() {
        Lottos manualLottos = manualLottoGenerator.generateLottos();
        Lottos autoLottos = new AutoLottoGenerator(numberOfAutoLottos).generateLottos();
        return Lottos.combine(manualLottos, autoLottos);
    }
}
