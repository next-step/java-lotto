package lotto.domain;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoStore {
    public static final int LOTTO_PRICE = 1_000;
    private static final int MINIMUM_ISSUE_COUNT = 1;
    private static final String NOT_VALID_ISSUE_COUNT = "로또 발급은 %d개 이상 가능합니다.";

    private final AutoLottoGenerator autoLottoGenerator;
    private final Money money;

    public LottoStore(Money money) {
        this.money = money;
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    public static LottoStore of(Money money) {
        return new LottoStore(money);
    }

    public Lottos issueLotto() {
        return Stream.generate(autoLottoGenerator::generate)
                .limit(calculateCount())
                .collect(collectingAndThen(toList(), Lottos::of));
    }

    public int calculateCount() {
        int count = money.getPrice() / LOTTO_PRICE;
        validate(count);
        return count;
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
        return Objects.equals(autoLottoGenerator, that.autoLottoGenerator) &&
                Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoLottoGenerator, money);
    }
}
