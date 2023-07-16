package lotto;

import lotto.domain.*;
import lotto.request.ManualRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {

    @Test
    @DisplayName("정상적인 입력이 들어오면 Lottos 객체가 생성된다.")
    void create() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lottos(lottos));
    }

    @Test
    @DisplayName("정상적인 입력이 들어오면 정적 팩토리 메소드로 Lottos 객체가 생성된다.")
    void from() {
        ManualRequest lottos = new ManualRequest(List.of(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatNoException()
                .isThrownBy(() -> Lottos.from(lottos));
    }

    @Test
    @DisplayName("크기를 반환한다.")
    void size() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        Assertions.assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("두 Lottos를 합친다.")
    void combine() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos1 = new Lottos(List.of(lotto1));
        Lottos lottos2 = new Lottos(List.of(lotto2));

        Assertions.assertThat(lottos1.combine(lottos2).getLottos()).contains(lotto1, lotto2);
    }
}
