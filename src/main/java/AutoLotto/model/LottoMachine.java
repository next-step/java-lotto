package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private static final String INVALID_PURCHASE_AMOUNT = "구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.\n관리자에게 문의하여 로또를 재구매하시기 바랍니다.";

    private List<Lotto> lottos;

    public LottoMachine(List<Lotto> manualLottos, int numberOfTotalLottos) {
        this.lottos = generateLottos(manualLottos, numberOfTotalLottos);
    }

    private List<Lotto> generateLottos(List<Lotto> manualLottos, int numberOfTotalLottos) {
        validatePurchaseAmount(manualLottos, numberOfTotalLottos);
        List<Lotto> lottos = setLottos(manualLottos, numberOfTotalLottos);
        return lottos;
    }

    private List<Lotto> setLottos(List<Lotto> manualLotto, int numberOfTotalLottos) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfAutoLottos = numberOfTotalLottos - manualLotto.size();

        lottos.addAll(setManualLottos(manualLotto));
        lottos.addAll(buyAutoLottos(numberOfAutoLottos, new RandomLottoGeneratorStrategy()));

        return lottos;
    }

    private List<Lotto> setManualLottos(List<Lotto> manualLottos) {
        if (manualLottos.size() == 0) {
            return new ArrayList<>();
        }

        return manualLottos;
    }

    private void validatePurchaseAmount(List<Lotto> manualLottos, int numberOfTotalLottos) {
        int numberOfAutoLottos = numberOfTotalLottos - manualLottos.size();

        if (numberOfAutoLottos < 0) {
            throw new PurchaseException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private List<Lotto> buyAutoLottos(int chances, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < chances; i++) {
            lottos.add(getAutoLotto(lottoGeneratorStrategy));
        }

        return lottos;
    }

    private Lotto getAutoLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Set<LottoNumber> randomLotto = lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy);

        return new Lotto(randomLotto);
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
