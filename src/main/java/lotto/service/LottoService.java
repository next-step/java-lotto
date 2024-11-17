package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;

public class LottoService {

    private static final LottoStore store = new LottoStore(new RandomLottoNumberGenerator());

    public Lottos buyLottos(List<String> passivityLottosInput, Money fee) {
        List<Lotto> passivityLottos = passivityLottos(passivityLottosInput);
        List<Lotto> autoLottos = autoLottos(calculateRemainingFee(fee, passivityLottos.size()));
        return new Lottos(passivityLottos, autoLottos);
    }

    private static Money calculateRemainingFee(Money fee, int count) {
        try {
            return fee.subtractedBill(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("수동로또 금액은 구매금액을 넘길 수 없습니다.");
        }
    }

    private static List<Lotto> passivityLottos(List<String> passivityLottosInput) {
        return store.passivityLottos(passivityLottosInput);
    }

    private static List<Lotto> autoLottos(Money fee) {
        return store.autoLottos(fee);
    }
}
