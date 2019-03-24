package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final int numberOfManualLotto;

    public PurchasedLottos(final Money amount, List<String> manualLottos, LottoGenerator lottoGenerator) {
        if (amount.isNotEnoughForPurchase()) {
            throw new RuntimeException("금액이 부족하여 로또를 구매할 수 없습니다.");
        }

        int totalNumberOfLotto = amount.calculateNumberOfLottoAvailableForPurchase();
        numberOfManualLotto = manualLottos.size();

        if (totalNumberOfLotto < numberOfManualLotto) {
            throw new RuntimeException("지불한 금액을 초과하여 수동 구매할 수 없습니다.");
        }
        addManualLotto(manualLottos, lottoGenerator);
        addAutoLotto(totalNumberOfLotto - numberOfManualLotto, lottoGenerator);
    }

    private void addManualLotto(List<String> manualLottos, LottoGenerator lottoGenerator) {
        lottos.addAll(manualLottos.stream()
                .map(lottoGenerator::generateLotto)
                .collect(Collectors.toList()));
    }

    private void addAutoLotto(int numberOfAutoLotto, LottoGenerator lottoGenerator) {
        for (int i = 0; i < numberOfAutoLotto; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }
}
