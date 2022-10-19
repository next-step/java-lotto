package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또를_출력() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto).isEqualTo(
            new Lotto(
                Number.of(12, 13, 14, 15, 16)
            )
        );
    }

    @Test
    void 당첨_번호로_로또_등수_확인() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto.checkRank(Number.of(12, 14, 15, 20, 22, 24)))
            .isEqualTo(Rank.FOURTH);
    }
}
