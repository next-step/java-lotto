package lotto_step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @DisplayName("숫자를 전달하면 그 개수만큼 lotto를 생성해 리스트로 반환한다.")
    @Test
    void lottosTest() {
        Lottos lottos = Lottos.from(3);

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("당첨번호를 전달하면 결과 리스트를 반환한다.")
    @Test
    void lottosMatchTest() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(Set.of(1, 3, 5, 7, 9, 11)),
                new Lotto(Set.of(12, 21, 23, 34, 35, 44))
        ));
        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        LottoResult match = lottos.match(winningLotto);

        assertThat(match).isInstanceOf(LottoResult.class);
    }
}