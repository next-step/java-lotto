package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.settings.LottoSettings;

public class LottoStore {

    private static final Money BASE_AMOUNT = new Money(LottoSettings.DEFAULT_PRICE.value());

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos buy(Money money, List<String> passivityLosttsInput) {
        if (isInvalidBaseUnit(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위이여야 합니다.");
        }

        List<Lotto> passivityLostts = passivityLostts(passivityLosttsInput);
        List<Lotto> autoLottos = autoLottos(money.subtracted(BASE_AMOUNT.multiply(passivityLostts.size())));

        return new Lottos(passivityLostts, autoLottos);
    }

    private List<Lotto> autoLottos(Money money) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < money.divide(BASE_AMOUNT); i++) {
            result.add(new Lotto(generateRandomNumbers()));
        }
        return result;
    }

    private static List<Lotto> passivityLostts(List<String> passivityLostts) {
        List<Lotto> result = new ArrayList<>();
        for (String passivityLostt : passivityLostts) {
            result.add(Lotto.from(passivityLostt));
        }
        return result;
    }

    private boolean isInvalidBaseUnit(Money fee) {
        return !fee.change(BASE_AMOUNT).equals(Money.zero());
    }

    private List<Integer> generateRandomNumbers() {
        int min = LottoSettings.MIN.value();
        int max = LottoSettings.MAX.value();
        int size = LottoSettings.SIZE.value();
        return lottoNumberGenerator.generate(min, max, size);
    }

    public Rank check(Lotto lotto, WinningLotto winning) {
        return winning.match(lotto);
    }
}
