package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPurchase {
    private static final long LOTTO_PRICE = 1_000;

    private final LottoCount count;
    private final List<Lotto> manualLottos;

    public LottoPurchase(Money money) {
        this(new LottoCount(calculateCount(money)));
    }

    public LottoPurchase(LottoCount count) {
        this(count, List.of());
    }

    public LottoPurchase(Money money, List<String> manualList) {
        this(new LottoCount(calculateCount(money)), convert(manualList));
    }

    public LottoPurchase(LottoCount count, List<Lotto> manualLottos) {
        this.count = count;
        this.manualLottos = manualLottos;
    }

    public Lottos purchase() {
        LottoGenerator compositeGenerator = new CompositeLottoGenerator(
                List.of(new ManualLottoGenerator(manualLottos), new AutoLottoGenerator(new LottoCount(autoCount()))));

        return compositeGenerator.generate();
    }

    public static List<Lotto> convert(List<String> manualList) {
        return manualList.stream()
                .map(Lotto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int calculateCount(Money money) {
        return (int)(money.getMoney() / LOTTO_PRICE);
    }

    public int count() {
        return count.value();
    }

    public int autoCount() {
        return count.value() - manualLottos.size();
    }
}
