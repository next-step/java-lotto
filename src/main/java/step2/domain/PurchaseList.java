package step2.domain;

import step2.domain.impl.AutoProvider;
import step2.domain.impl.ManualProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseList {

    private static final AutoProvider AUTO_PURCHASE = new AutoProvider();

    private final List<Lotto> values;

    public PurchaseList(PurchaseMoney purchaseMoney, List<String> manualNumbers) {
        List<NumberProvider> strategies = initStrategies(purchaseMoney, manualNumbers);
        this.values = strategies.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<NumberProvider> initStrategies(PurchaseMoney purchaseMoney, List<String> manualNumbers) {
        List<NumberProvider> strategies = new ArrayList<>();
        strategies.addAll(purchaseManual(manualNumbers));
        strategies.addAll(purchaseAuto(purchaseMoney.calculateAutoPurchaseCount()));
        return strategies;
    }

    private List<ManualProvider> purchaseManual(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(ManualProvider::new)
                .collect(Collectors.toList());
    }

    private List<AutoProvider> purchaseAuto(int autoCount) {
        List<AutoProvider> result = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            result.add(AUTO_PURCHASE);
        }
        return result;
    }

    public List<LottoRank> calculateRankEach(WinningLotto winningLotto) {
        return values.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.values.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
