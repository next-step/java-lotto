package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 하나에는 번호가 6개 저장되지 않으면 Exception이 발생되어야 한다.")
    void lottoSavaNumberSizeTest() {

        // given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또 번호의 개수는 6개가 들어와야 한다.");
    }

}