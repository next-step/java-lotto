package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ManualLottosTest {

    @Test
    void 수동_로또_컬렉션_리스트받아서_객체_생성시_정상적으로_데이터_담기_성공() {
        // given, when
        ManualLottos lottos = new ManualLottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        // then
        assertThat(lottos.getLottos()).isEqualTo(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

    }
}
