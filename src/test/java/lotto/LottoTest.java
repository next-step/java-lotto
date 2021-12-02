package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("숫자 6개가 담긴 Lotto 객체를 생성한다.")
    void shouldCreate() {
        Lotto lotto = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
    }
}