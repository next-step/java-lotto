package lotto;

import lotto.domain.Lotto;
import lotto.domain.entity.Number;
import lotto.domain.generator.AutomaticLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 1장은 6개의 숫자를 가진다.")
    public void 로또_1장의_사이즈_확인() {
        Lotto automaticLotto = new Lotto(new AutomaticLottoGenerator());
        assertThat(automaticLotto.size()).isEqualTo(6);

        assertThatThrownBy(() -> new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 숫자는 6개이여야 합니다.");

        assertThatThrownBy(() -> new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6), new Number(7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 숫자는 6개이여야 합니다.");
    }

    @Test
    @DisplayName("로또 1장은 중복되지 않은 숫자를 가진다.")
    public void 중복되지_않은_숫자() {
        assertThatThrownBy(() -> new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 가질수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 1장의 6개 숫자는 1부터 45까지의 범위를 가진다")
    @ValueSource(ints = {0, 46})
    public void 로또_숫자_범위(int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자 범위는 1 ~ 45 사이입니다.");
    }
}