package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {
    private LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    private final String[] inputManualLottoValues;

    public ManualLottoGenerator(String[] inputManualLottoValues) {
        this.inputManualLottoValues = inputManualLottoValues;
    }

    private List<Lotto> generateManualLottos(String[] values) {
        List<Lotto> lottos = new ArrayList<>();
        for(String v : values) {
            lottos.add(Lotto.fromComma(v));
        }
        return lottos;
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> manualLottos = generateManualLottos(inputManualLottoValues);
        List<Lotto> autoLottos = autoLottoGenerator.generate(money.autoLottoMoney(manualLottos.size()));
        manualLottos.addAll(autoLottos);
        return manualLottos;
    }
}
