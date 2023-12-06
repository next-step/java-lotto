package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @DisplayName("구매 정보와 수동으로 구매할 로또정를 전달하면 lotto를 생성해 리스트로 반환한다.")
    @Test
    void lottosTest() {
        LottoBuyInfo buyInfo = new LottoBuyInfo(5000, 2);
        ManualLottos manualLottos = new ManualLottos(List.of("1, 2, 3, 4, 5, 6", "2, 4, 5, 6, 8, 11"));
        Lottos lottos = Lottos.from(buyInfo, manualLottos);

        assertThat(lottos.size()).isEqualTo(5);
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
