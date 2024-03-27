package autoLotto.model;

import autoLotto.exception.PurchaseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final String INVALID_PURCHASE_AMOUNT = "구입하신 수동 로또의 개수가 전체 로또 개수보다 많습니다.\n관리자에게 문의하여 로또를 재구매하시기 바랍니다.";
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    private List<Lotto> lottos;

    public LottoMachine(List<String> manualLottos, LottoPurchaseCount purchaseCount) {
        this.lottos = generateLottos(manualLottos, purchaseCount);
    }

    private List<Lotto> generateLottos(List<String> manualLottos, LottoPurchaseCount purchaseCount) {
        validatePurchaseAmount(manualLottos, purchaseCount);
        return setLottos(manualLottos, purchaseCount);
    }

    private List<Lotto> setLottos(List<String> manualLotto, LottoPurchaseCount purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(buyManualLottos(manualLotto, new ManualLottoGeneratorStrategy()));
        lottos.addAll(buyAutoLottos(purchaseCount, new RandomLottoGeneratorStrategy()));

        return lottos;
    }

    private List<Lotto> buyManualLottos(List<String> manualLottos, LottoGeneratorStrategy lottoGeneratorStrategy) {
        if (manualLottos.size() == 0) {
            return new ArrayList<>();
        }

        List<Lotto> lottos = new ArrayList<>();

        for (String lotto : manualLottos) {
            List<Integer> lottoAsListInteger = convertStringToIntegerList(lotto);
            lottos.add(new Lotto(lottoGenerator.generateManualLottoNumbers(lottoGeneratorStrategy, lottoAsListInteger)));
        }

        return lottos;
    }

    private void validatePurchaseAmount(List<String> manualLottos, LottoPurchaseCount purchaseCount) {
        int numberOfAutoLottos = purchaseCount.getNumberOfTotalLottos() - manualLottos.size();

        if (numberOfAutoLottos < 0) {
            throw new PurchaseException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private List<Lotto> buyAutoLottos(LottoPurchaseCount purchaseCount, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount.getNumberOfAutoLottos(); i++) {
            lottos.add(getAutoLotto(lottoGeneratorStrategy));
        }

        return lottos;
    }

    private Lotto getAutoLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        Set<LottoNumber> randomLotto = lottoGenerator.generateRandomLottoNumbers(lottoGeneratorStrategy);

        return new Lotto(randomLotto);
    }

    private List<Integer> convertStringToIntegerList(String string) {
        return Arrays.stream(string.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
