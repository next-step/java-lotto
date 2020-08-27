package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoStore {
    public static final int ZERO = 0;
    public static final int LOTTO_PRICE = 1_000;
    private static final int MINIMUM_ISSUE_COUNT = 1;
    private static final String NOT_VALID_ISSUE_COUNT = "로또 발급은 %d개 이상 가능합니다.";

    private final Money money;
    private final ManualLotto manualLotto;

    public LottoStore(Money money, ManualLotto manualLotto) {
        this.money = money;
        this.manualLotto = manualLotto;
    }

    public static LottoStore of(Money money, ManualLotto manualLotto) {
        return new LottoStore(money, manualLotto);
    }

    public Lottos issue() {
        List<Lotto> lottos = issueManualLotto();
        lottos.addAll(issueAutoLotto());
        return Lottos.of(lottos);
    }

    public List<Lotto> issueAutoLotto() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        return Stream.generate(autoLottoGenerator::generate)
                .limit(calculateCount(money.getPrice()))
                .collect(toList());
    }

    public List<Lotto> issueManualLotto() {
        return manualLotto.getNumberTexts()
                .stream()
                .map(numberText -> ManualLottoGenerator.of(numberText).generate())
                .collect(toList());
    }

    public int purchaseCount(int price) {
        int count = price / LOTTO_PRICE;
        validate(count);
        return count;
    }

    public int calculateCount(int price) {
        return purchaseCount(price) - manualLotto.size();
    }

    private void validate(int count) {
        if (count < MINIMUM_ISSUE_COUNT) {
            throw new IllegalArgumentException(String.format(NOT_VALID_ISSUE_COUNT, MINIMUM_ISSUE_COUNT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStore that = (LottoStore) o;
        return Objects.equals(money, that.money) &&
                Objects.equals(manualLotto, that.manualLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, manualLotto);
    }
}
