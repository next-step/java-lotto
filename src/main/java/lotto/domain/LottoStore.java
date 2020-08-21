package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1_000;
    private static final int MINIMUM_ISSUE_COUNT = 1;
    private static final String NOT_VALID_ISSUE_COUNT = "로또 발급은 %d개 이상 가능합니다.";

    private final AutoLottoGenerator autoLottoGenerator;
    private final Money money;

    public LottoStore(Money money) {
        this.autoLottoGenerator = new AutoLottoGenerator();
        this.money = money;
    }

    public static LottoStore of(Money money) {
        return new LottoStore(money);
    }

    public Lottos issueLotto() {
        validate(findLottoCount());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < findLottoCount(); i++) {
            lottos.add(autoLottoGenerator.generate());
        }
        return Lottos.of(lottos);
    }

    public int getPurchasePrice() {
        return findLottoCount() * LOTTO_PRICE;
    }

    public int findLottoCount() {
        return money.getPrice() / LOTTO_PRICE;
    }

    private void validate(int count) {
        if (count < MINIMUM_ISSUE_COUNT) {
            throw new IllegalArgumentException(String.format(NOT_VALID_ISSUE_COUNT, MINIMUM_ISSUE_COUNT));
        }
    }
}
