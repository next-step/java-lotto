package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {
    @DisplayName("로또를 여러개 생성할 수 있다.")
    @Test
    void createLottos() {
        ManualLotto lottoA = ManualLotto.create(List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));
        ManualLotto lottoB = ManualLotto.create(List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        Lottos lottos = new Lottos(List.of(lottoA, lottoB));
        assertThat(lottos.values()).hasSize(2);
    }

    @DisplayName("로또를 0개 생성하는 경우 예외 발생")
    @Test
    void createZeroLottos() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lottos.create(List.of()));
    }
}