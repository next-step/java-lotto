package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @DisplayName("Lotto 리스트를 전달하면 Lottos 객체를 생성한다.")
    @Test
    void lottosTest() {
        assertThat(new Lottos(List.of(
                new Lotto(Set.of(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6)
                )),
                new Lotto(Set.of(
                        LottoNumber.from(1),
                        LottoNumber.from(3),
                        LottoNumber.from(5),
                        LottoNumber.from(7),
                        LottoNumber.from(9),
                        LottoNumber.from(11)
                ))
        ))).isInstanceOf(Lottos.class);
    }

    @DisplayName("숫자를 전달하면 로또 리스트를 생성해 반환한다.")
    @Test
    void 로또리스트_숫자_생성() {
        Lottos lottos = Lottos.from(3);

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("수동 로또 리스트를 전달하면 로또 리스트를 생성해 반환한다.")
    @Test
    void 로또리스트_수동로또_생성() {
        ManualLottos manualLottos = new ManualLottos(List.of("1, 2, 3, 4, 5, 6", "2, 4, 6, 8, 10, 12"));
        Lottos lottos = Lottos.from(manualLottos);

        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("두개의 로또 리스트를 전달하면 하나의 로또 리스트를 생성해 반환한다.")
    @Test
    void 로또리스트_수동_숫자_생성() {
        Lottos manualLottos = Lottos.from(new ManualLottos(List.of("1, 2, 3, 4, 5, 6", "2, 4, 6, 8, 10, 12")));
        Lottos autoLottos = Lottos.from(3);

        assertThat(Lottos.of(manualLottos, autoLottos)).isInstanceOf(Lottos.class);
    }

    @DisplayName("match메서드를 호출하면 결과 리스트를 반환한다.")
    @Test
    void winningLottoMatchTest() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(Set.of(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6)
                )),
                new Lotto(Set.of(
                        LottoNumber.from(1),
                        LottoNumber.from(3),
                        LottoNumber.from(5),
                        LottoNumber.from(7),
                        LottoNumber.from(9),
                        LottoNumber.from(11)
                )),
                new Lotto(Set.of(
                        LottoNumber.from(11),
                        LottoNumber.from(12),
                        LottoNumber.from(13),
                        LottoNumber.from(14),
                        LottoNumber.from(15),
                        LottoNumber.from(16)
                ))
        ));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        )), LottoNumber.from(11));

        LottoResult match = lottos.match(winningLotto);

        assertThat(match).isInstanceOf(LottoResult.class);
    }
}
