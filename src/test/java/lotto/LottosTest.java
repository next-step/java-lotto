package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {

    @Test
    @DisplayName("로또 일급 콜렉션 생성 테스트")
    void create() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lottos(lottos));
    }
}
