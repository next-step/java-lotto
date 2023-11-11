package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {


    @Test
    @DisplayName("3개의 로또를 구매하는 경우 3개의 로또가 생성된다.")
    void createLottos() {
        Lottos lottos = Lottos.of(3);

        assertThat(lottos.getLottos()).hasSize(3);
        assertThat(lottos.getTotalTicketCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("불변객체인 lottos 배열을 수정할 경우 오류가 발생한다.")
    void lottos_불변객체() {
        List<Lotto> lottos = Lottos.of(3).getLottos();

        assertThatThrownBy(lottos::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
}