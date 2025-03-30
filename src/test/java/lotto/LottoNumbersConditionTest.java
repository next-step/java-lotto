package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersConditionTest {
    @DisplayName("LottoNumbers 1~45 사이의 수 여부 테스트")
    @Test
    public void isNumberValid() throws Exception {
        new LottoNumbersCondition(1,45, 6);
        assertThat(new LottoNumbers(Set.of(1,2,3,4,5,6)))
                .isNotNull();

        assertThatThrownBy(() -> new LottoNumbers(Set.of(1,2,3,4,5,0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires a number between 1 and 45");
    }

    @DisplayName("LottoNumbers 6개 수 여부 테스트")
    @Test
    public void isSizeValid() throws Exception {
        new LottoNumbersCondition(1,45, 6);
        assertThat(new LottoNumbers(Set.of(1,2,3,4,5,6)))
                .isNotNull();

        assertThatThrownBy(() -> new LottoNumbers(Set.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires 6 numbers.");
    }
}