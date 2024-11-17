package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lotto.settings.LottoSettings;

public class LottoStore {


    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> autoLottos(Money money) {
        return createLottoList(money.countBill(), (idx) -> new Lotto(generateRandomNumbers()));
    }

    public List<Lotto> passivityLostts(List<String> passivityLostts) {
        return createLottoList(passivityLostts.size(), (idx) -> Lotto.from(passivityLostts.get(idx)));
    }

    private List<Lotto> createLottoList(int size, Function<Integer, Lotto> lottoGenerator) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(lottoGenerator.apply(i));
        }
        return result;
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
