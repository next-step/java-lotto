package lotto.model;

import lotto.generator.AutoLottoGeneratorStrategy;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoGeneratorStrategy;
import lotto.generator.ManualLottoGeneratorStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.InputView.COMMA_DELIMITER;

public class LottoMachine {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    private List<Lotto> lottos;

    public LottoMachine(List<String> manualLottos, PurchaseAmount purchaseAmount) {
        this.lottos = generateLottos(manualLottos, purchaseAmount);
    }

    private List<Lotto> generateLottos(List<String> manualLottos, PurchaseAmount purchaseAmount) {
        purchaseAmount.isValidPurchaseNumberOfManualLotto(manualLottos.size());
        return setLottos(manualLottos, purchaseAmount.getNumberOfTotalLottos());
    }

    private List<Lotto> setLottos(List<String> manualLottos, int numberOfTotalLottos) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(buyManualLottos(manualLottos));
        lottos.addAll(buyAutoLottos(numberOfTotalLottos - manualLottos.size(),
                        new AutoLottoGeneratorStrategy()));

        return lottos;
    }

    private List<Lotto> buyManualLottos(List<String> manualLottos) {
        if (manualLottos.size() == 0) {
            return new ArrayList<>();
        }

        List<Lotto> lottos = new ArrayList<>();

        for (String lotto : manualLottos) {
            List<String> lottoAsListString = Arrays.stream(lotto.split(COMMA_DELIMITER))
                            .collect(Collectors.toList());
            lottos.add(lottoGenerator.generateLottoNumbers(new ManualLottoGeneratorStrategy(lottoAsListString)));
        }

        return lottos;
    }

    private List<Lotto> buyAutoLottos(int numberOfAutoLottos, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfAutoLottos; i++) {
            lottos.add(lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy));
        }

        return lottos;
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
