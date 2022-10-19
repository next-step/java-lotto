package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또를_출력() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12, 11);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto).isEqualTo(
            new Lotto(
                Number.of(11, 12, 13, 14, 15, 16)
            )
        );
    }

    @Test
    void 당첨_번호로_로또_등수_확인() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12, 11);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto.checkRank(Number.of(12, 14, 15, 20, 22, 24), Number.of(25)))
            .isEqualTo(Rank.FOURTH);
    }

    @Test
    void 로또의_숫자_갯수는_6개_이다() {
        Assertions.assertThatThrownBy(() -> new Lotto(Number.of(1, 2)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또의 숫자 갯수는 6개 입니다.");
    }
}
