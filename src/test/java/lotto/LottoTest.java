package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("Lotto 객체를 생성한다")
    void shouldCreateSameObject() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
