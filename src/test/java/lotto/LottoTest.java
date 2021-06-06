package lotto;

import lotto.domain.Lotto;
import lotto.domain.generator.AutomaticLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 1장은 6개의 숫자를 가진다.")
    public void 로또_1장의_사이즈_확인() {
        Lotto automaticLotto = new Lotto(new AutomaticLottoNumbersGenerator());
        assertThat(automaticLotto.size()).isEqualTo(6);

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 숫자는 6개이여야 합니다.");

        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 숫자는 6개이여야 합니다.");
    }

    @Test
    @DisplayName("로또 1장은 중복되지 않은 숫자를 가진다.")
    public void 중복되지_않은_숫자() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 가질수 없습니다.");
    }
}