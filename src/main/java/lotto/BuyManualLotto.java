package lotto;


import java.util.List;
import java.util.stream.Collectors;

public final class BuyManualLotto extends BuyLotto {
    public BuyManualLotto(Money money, int count, List<LottoNumberStrategy> strategies) {
        super(money, count, strategies);
    }

    public static BuyManualLotto create(Money money, int count, List<List<Integer>> manualNumbers) {
        return new BuyManualLotto(money, count, createManualNumberStrategy(manualNumbers));
    }

    private static List<LottoNumberStrategy> createManualNumberStrategy(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(ManualLottoNumberStrategy::new)
                .collect(Collectors.toList());
    }
}
