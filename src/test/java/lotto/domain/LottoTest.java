package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLotto() {
        // given
        String input = "6,2,3,4,5,1";
        // when
        Lotto lotto = Lotto.of(input);
        // then
        assertThat(lotto.toArray()).isEqualTo(new int[] {1, 2, 3, 4, 5, 6});
    }
}
