package lotto.domain.policy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public interface LottoPolicy {

    Lotto ball();

    class FakeLottoPolicy implements LottoPolicy {

        @Override
        public Lotto ball() {
            return new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
            ));
        }
    }
}
