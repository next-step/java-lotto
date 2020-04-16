package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("로또는 6개의 번호로 구성")
    @Test
    void create() {
        assertThatCode(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 중복시 에러")
    @Test
    void duplicatedNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

    @DisplayName("로또 번호 6개가 아닐시 에러")
    @Test
    void invalidSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

}