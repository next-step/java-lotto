package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = Lotto.of(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("로또 번호는 6개이다.")
    void count() {
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void duplicate() {
        assertThatThrownBy(() -> Lotto.of(List.of(1,2,3,4,5,5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 true 를 반환한다.")
    void bonus() {
        boolean isMatched = lotto.matchBonus(LottoNumber.from(6));
        assertThat(isMatched).isTrue();
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 false 를 반환한다.")
    void doesNotMatchBonus() {
        boolean isMatched = lotto.matchBonus(LottoNumber.from(7));
        assertThat(isMatched).isFalse();
    }
}
