package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또의 가격은 1000원이다")
    @Test
    void price() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }

    @DisplayName("로또 숫자의 개수가 지정된 개수와 같지 않으면 IllegalArgumentException")
    @Test
    void countOfNumbers() {
        assertThatThrownBy(() -> new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
