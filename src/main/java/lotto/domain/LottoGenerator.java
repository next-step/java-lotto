package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1_000;

    private int money;
    private int purchaseCount;

    public LottoGenerator(int money, int purchaseCount) {
        validateInputValue(money);
        this.money = money;
        this.purchaseCount = purchaseCount;
    }

    public LottoGenerator(int amount) {
        this(amount, 0);
    }

    private void validateInputValue(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한장의 금액은 1000원 입니다.");
        }
    }

    public List<Lotto> generatorLottos(List<String> manualLottos) {
        validateInputValue(manualLottos);
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(generateLottosByStrategy(new ManualLottoGeneratorStrategy(manualLottos)));
        lottos.addAll(generateLottosByStrategy(new AutoLottoGeneratorStrategy(purchasableLottoCount())));
        return lottos;
    }

    private void validateInputValue(List<String> manualLottos) {
        int quantity = manualLottos.size();
        if (money < quantity * LOTTO_PRICE) {
            throw new IllegalArgumentException("현재 금액으로 수동 로또 " + quantity + "장을 살 수 없습니다.");
        }
        this.money -= quantity * LOTTO_PRICE;
        this.purchaseCount += quantity;
    }

    private List<Lotto> generateLottosByStrategy(LottoGeneratorStrategy strategy) {
        return strategy.generateLottos();
    }

    private int purchasableLottoCount() {
        return money / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseCount * LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGenerator that = (LottoGenerator) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
