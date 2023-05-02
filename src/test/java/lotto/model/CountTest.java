package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CountTest {

    @Test
    @DisplayName("개수는 음수일 수 없다")
    public void nonNegative() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Count(-1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "999:0", "0:0", "2000:2"}, delimiter = ':')
    @DisplayName("금액에 따라 적절한 로또 개수를 알 수 있다")
    public void byPrice(int inputPrice, int expected) {
        Price price = new Price(inputPrice);

        assertThat(Count.of(price)).isEqualTo(new Count(expected));
    }
}