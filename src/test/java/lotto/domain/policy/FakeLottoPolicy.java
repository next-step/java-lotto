package lotto.domain.policy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberFactory;

public class FakeLottoPolicy implements LottoPolicy {

    @Override
    public Lotto ball() {
        return new Lotto(List.of(
            LottoNumberFactory.getLottoNumber(1),
            LottoNumberFactory.getLottoNumber(2),
            LottoNumberFactory.getLottoNumber(3),
            LottoNumberFactory.getLottoNumber(4),
            LottoNumberFactory.getLottoNumber(5),
            LottoNumberFactory.getLottoNumber(6)
        ));
    }
}
