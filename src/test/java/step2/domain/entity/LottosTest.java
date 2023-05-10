package step2.domain.entity;

import java.util.List;

class LottosTest {

    private Lottos createTestLottos() {
        final var lotto1 = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);
        final var lotto2 = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);

        return new Lottos(List.of(lotto1, lotto2));
    }

}
