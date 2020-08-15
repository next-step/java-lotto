package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @Test
    @DisplayName("로또 자동생성 사이즈 확인")
    void generateAuto() {
        // given
        final int count = 100;
        Lottos lottos = new Lottos(100);

        // when
        lottos.fillAuto();

        // then
        assertThat(lottos).hasSize(count);
    }

    @Test
    @DisplayName("로또 추가 및 사이즈 확인")
    void add() {
        // given
        final int count = 10;
        Lottos lottos = new Lottos(count);

        // when
        lottos.add(Lotto.generateAuto());

        // then
        assertThat(lottos).hasSize(1);
    }

    @Test
    @DisplayName("로또 가격 확인")
    void getTotalPrice() {
        // given
        final int count = 10;
        Lottos lottos = new Lottos(count);

        // when
        lottos.fillAuto();

        // then
        assertThat(lottos.getTotalPrice()).isEqualTo(count * LottoShop.DEFAULT_PRICE_UNIT);
    }

    @Test
    @DisplayName("로또 사이즈 보다 많이 등록 시 예외")
    void add_overSize_exceptThrown() {
        final int count = 1;
        Lottos lottos = new Lottos(count);
        lottos.add(Lotto.generateAuto());
        assertThatThrownBy(() -> lottos.add(Lotto.generateAuto())).isInstanceOf(IllegalStateException.class);
    }

}
