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
        this.lotto = Lotto.of(
            List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));
    }

    @Test
    @DisplayName("로또 번호는 6개이다.")
    void count() {
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void duplicate() {
        assertThatThrownBy(() -> Lotto.of(
            List.of(LottoNumber.from(1), LottoNumber.from(1), LottoNumber.from(1),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)))).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지난 주 당첨 번호와 일치하는 개수를 반환한다.")
    void matches() {
        Lotto winningNumbers = Lotto.of(
            List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(10)));
        assertThat(lotto.matches(winningNumbers)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 true 를 반환한다.")
    void bonus() {
        int bonus = 1;
        assertThat(lotto.matches(bonus)).isTrue();
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 false 를 반환한다.")
    void doesNotMatchBonus() {
        int bonus = 10;
        assertThat(lotto.matches(bonus)).isFalse();
    }
}
